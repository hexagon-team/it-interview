package com.hexagonteam.itinterview.database

import com.hexagonteam.itinterview.ItInterviewDatabase
import com.hexagonteam.itinterview.database.DatabaseConstants.DB_NAME
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

internal actual class DatabaseDrivenFactory {
  actual fun createDriven(): SqlDriver {
    return NativeSqliteDriver(
      schema = ItInterviewDatabase.Schema,
      name = DB_NAME,
    )
  }
}