package com.hexagonteam.itinterview.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Base application store, which implements MVI architecture, store keeps screen state
 * inside, and processing ui events.
 * @param State current screen state, single parameter,
 * TODO: Probably class should extend expected class-realization \
 *  of platform-specific view model
 */
abstract class BaseStore<State : UiState> {
  private val _state by lazy { MutableStateFlow(initialState) }
  private val _effects = Channel<UiEffect>(capacity = 16)

  protected val scope = CoroutineScope(Dispatchers.Default)
  protected abstract val initialState: State

  val state: Flow<State> get() = _state.asStateFlow()
  val effects: Flow<UiEffect> get() = _effects.receiveAsFlow()

  /**
   * Single entry point of store. That function should be invoked, when
   * ui intent to do anything. Method launching and processing events asynchronously
   * via [handleEvent] method invoke.
   * @param event intent of ui, which should be processed
   */
  fun processEvent(event: UiEvent) {
    scope.launch { handleEvent(event) }
  }

  /**
   * Single lifecycle method for store, should be invoked when store destroying.
   * Here is view model's scope will be canceled and view model resources should be recycled.
   * TODO: find out where it will be used
   */
  open fun onCleared() {
    scope.cancel()
  }

  /**
   * Internal async event handler, child should override it to handle
   * any event, which was produced via ui
   */
  protected open suspend fun handleEvent(event: UiEvent) = Unit

  protected fun postState(state: State) {
    _state.value = state
  }

  protected suspend fun postUiEffect(effect: UiEffect) {
    _effects.send(effect)
  }
}