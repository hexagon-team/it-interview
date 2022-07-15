package com.hexagonteam.itinterview.data.local

import com.hexagonteam.itinterview.ItInterviewDatabase
import com.squareup.sqldelight.Transacter

internal class ExampleDao(
  database: ItInterviewDatabase
) : Dao(database) {
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