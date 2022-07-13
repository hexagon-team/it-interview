package com.hexagonteam.itinterview.ktor

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.engine.darwin.*

internal actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(
  Darwin
) {
  config(this)

  engine {
    configureRequest {
      setAllowsCellularAccess(true)
    }
  }
}

internal actual fun initLogging() {
  Napier.base(DebugAntilog())
}