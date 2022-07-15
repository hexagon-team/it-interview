package com.hexagonteam.itinterview.database

import com.squareup.sqldelight.db.SqlDriver

internal expect class DatabaseDrivenFactory {
  fun createDriven(): SqlDriver
}