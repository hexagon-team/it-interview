package com.hexagonteam.itinterview.data.local

import com.hexagonteam.itinterview.database.DatabaseDrivenFactory
import com.squareup.sqldelight.Transacter

// FIXME: Create instance by koin injections
class ExampleDao(databaseDrivenFactory: DatabaseDrivenFactory) : Dao(databaseDrivenFactory) {
  override val queries: Transacter get() = database.exampleTableQueries

  /*
  //select all query example

  suspend fun selectAll(): List<ExampleDto> = withContext(Dispatchers.Default) {
    queries.selectAll().executeAsList().map {
      ExampleDto(
        title = it.title
      )
    }
  } */
}