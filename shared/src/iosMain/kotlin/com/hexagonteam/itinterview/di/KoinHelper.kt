package com.hexagonteam.itinterview.di

import com.hexagonteam.itinterview.data.remote.ExampleRepository
import com.hexagonteam.itinterview.di.modules.SharedModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class KoinComponent : KoinComponent {
  val exampleRepository by inject<ExampleRepository>()
}

fun initKoin() {
  startKoin {
    modules(SharedModule)
  }
}