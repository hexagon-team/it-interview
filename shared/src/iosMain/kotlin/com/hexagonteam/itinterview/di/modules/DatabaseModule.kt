package com.hexagonteam.itinterview.di.modules

import com.hexagonteam.itinterview.database.DatabaseDrivenFactory
import org.koin.dsl.module

internal actual val DatabaseDriverModule = module {
  single { DatabaseDrivenFactory().createDriven() }
}