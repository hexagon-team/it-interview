package com.hexagonteam.itinterview.redux.interfaces

interface Middleware<State> {

  fun process(
    currentState: State,
    action: Action,
    dispatcher: Store.Dispatcher
  ): Action
}
