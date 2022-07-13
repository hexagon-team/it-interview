package com.hexagonteam.itinterview.database

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDrivenFactory {
  fun createDriven(): SqlDriver
}