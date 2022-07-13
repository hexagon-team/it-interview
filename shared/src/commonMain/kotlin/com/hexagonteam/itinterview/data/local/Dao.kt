package com.hexagonteam.itinterview.data.local

import com.hexagonteam.itinterview.ItInterviewDatabase
import com.hexagonteam.itinterview.database.DatabaseDrivenFactory
import com.squareup.sqldelight.Transacter

abstract class Dao(databaseDrivenFactory: DatabaseDrivenFactory) {
  // FIXME: Create from koin di
  protected val database = ItInterviewDatabase(databaseDrivenFactory.createDriven())
  abstract val queries: Transacter
}