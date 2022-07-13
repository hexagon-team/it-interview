package com.hexagonteam.itinterview.ktor

import io.ktor.client.*

internal val SerializableHttpClient: HttpClient = httpClient() {
  installJsonSerialization()
  installLogging()
}.also {
  initLogging()
}