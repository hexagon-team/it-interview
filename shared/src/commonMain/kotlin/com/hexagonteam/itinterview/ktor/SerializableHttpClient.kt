package com.hexagonteam.itinterview.ktor

import io.ktor.client.*

internal object SerializableHttpClient {
  val httpClient: HttpClient = httpClient() {
    installJsonSerialization()
    installLogging()
  }.also {
    initLogging()
  }
}