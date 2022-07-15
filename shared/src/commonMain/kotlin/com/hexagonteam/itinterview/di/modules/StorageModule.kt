package com.hexagonteam.itinterview.di.modules

import com.hexagonteam.itinterview.data.local.ExampleDao
import org.koin.dsl.module

internal val DaoModule = module {
  module { DatabaseModule }

  single { ExampleDao(get()) }
}