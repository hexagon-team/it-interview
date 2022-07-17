package com.hexagonteam.itinterview.redux.interfaces

interface Reducer<State> {

  fun reduce(oldState: State, action: Action): State
}