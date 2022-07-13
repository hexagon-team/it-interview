package com.hexagonteam.itinterview.database

import android.content.Context
import com.hexagonteam.itinterview.ItInterviewDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDrivenFactory(
  private val context: Context
) {
  actual fun createDriven(): SqlDriver {

    return AndroidSqliteDriver(
      schema = ItInterviewDatabase.Schema,
      context = context,
      name = "it_interview.db",
    )
  }
}