package com.hexagonteam.itinterview.database

import android.content.Context
import com.hexagonteam.itinterview.ItInterviewDatabase
import com.hexagonteam.itinterview.database.DatabaseConstants.DB_NAME
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

internal actual class DatabaseDrivenFactory(
  private val context: Context
) {
  actual fun createDriven(): SqlDriver {
    return AndroidSqliteDriver(
      schema = ItInterviewDatabase.Schema,
      context = context,
      name = DB_NAME,
    )
  }
}