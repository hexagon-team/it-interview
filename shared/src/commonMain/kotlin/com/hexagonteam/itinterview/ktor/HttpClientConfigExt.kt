package com.hexagonteam.itinterview.ktor

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal fun HttpClientConfig<*>.installLogging() {
  install(Logging) {
    level = LogLevel.ALL
    logger = object : Logger {
      override fun log(message: String) {
        Napier.v(
          message = message,
          tag = "HTTP Client"
        )
      }
    }
  }
}

internal fun HttpClientConfig<*>.installJsonSerialization() {
  install(ContentNegotiation) {
    val jsonConfig = Json {
      prettyPrint = true
      isLenient = true
      ignoreUnknownKeys = true
    }

    json(jsonConfig)
  }
}