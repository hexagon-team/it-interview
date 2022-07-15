package com.hexagonteam.itinterview.redux.interfaces

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface Store<State> {

  val state: StateFlow<State>
  val sideEffects: SharedFlow<SideEffect>

  fun dispatch(action: Action)

  interface Dispatcher {

    fun dispatch(action: Action)

    fun postSideEffect(sideEffect: SideEffect)
  }
}