package com.hexagonteam.itinterview.ktor

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

internal actual fun httpClient(
  config: HttpClientConfig<*>.() -> Unit
): HttpClient = HttpClient(OkHttp) {
  config(this)

  engine {
    config {
      retryOnConnectionFailure(true)
      connectTimeout(10, TimeUnit.SECONDS)
    }
  }
}

internal actual fun initLogging() {
  Napier.base(DebugAntilog())
}