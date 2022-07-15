package com.hexagonteam.itinterview.data.local

import com.hexagonteam.itinterview.ItInterviewDatabase
import com.squareup.sqldelight.Transacter

abstract class Dao internal constructor(
  internal val database: ItInterviewDatabase,
) {
  abstract val queries: Transacter
}