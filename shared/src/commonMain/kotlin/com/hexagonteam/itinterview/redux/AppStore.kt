package com.hexagonteam.itinterview.redux

import com.hexagonteam.itinterview.redux.interfaces.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AppStore(
  private val middlewares: List<Middleware<AppState>>,
  private val reducers: List<Reducer<AppState>>
) : Store<AppState> {
  @OptIn(ExperimentalCoroutinesApi::class)
  // TODO: Replace default kotlin Native Dispatcher to custom expect Dispatcher
  //  https://github.com/hexagon-team/it-interview/issues/11
  private val scope = CoroutineScope(Dispatchers.Default.limitedParallelism(1))
  
  private val dispatcher = DispatcherImpl()

  private val _state = MutableStateFlow(AppState(EmptyState))
  private val _sideEffects = MutableSharedFlow<SideEffect>(
    extraBufferCapacity = 16,
    onBufferOverflow = BufferOverflow.DROP_OLDEST
  )

  override val state: StateFlow<AppState> = _state.asStateFlow()
  override val sideEffects: SharedFlow<SideEffect> = _sideEffects.asSharedFlow()

  override fun dispatch(action: Action) {
    scope.launch {
      val currentState = _state.value
      val newAction = middlewares.fold(action) { currentAction, middleware ->
        middleware.process(
          currentState = currentState,
          action = currentAction,
          dispatcher = dispatcher
        )
      }

      val newState = reducers.fold(currentState) { state, reducer ->
        reducer.reduce(state, newAction)
      }
      _state.value = newState
    }
  }

  inner class DispatcherImpl : Store.Dispatcher {
    override fun dispatch(action: Action) {
      this@AppStore.dispatch(action)
    }

    override fun postSideEffect(sideEffect: SideEffect) {
      _sideEffects.tryEmit(sideEffect)
    }
  }
}