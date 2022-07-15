@file:JvmName("common")

package com.hexagonteam.itinterview.ktor

import io.ktor.client.*
import kotlin.jvm.JvmName

internal expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
internal expect fun initLogging()