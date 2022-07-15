package com.hexagonteam.itinterview.di.modules

import com.hexagonteam.itinterview.ItInterviewDatabase
import org.koin.dsl.module

internal val DatabaseModule = module {
  module { DatabaseDriverModule }

  single { ItInterviewDatabase(get()) }
}