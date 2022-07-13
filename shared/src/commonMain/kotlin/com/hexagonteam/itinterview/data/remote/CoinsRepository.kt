package com.hexagonteam.itinterview.data.remote

import com.hexagonteam.itinterview.ktor.SerializableHttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

abstract class Repository {
  // FIXME: create instance by koin
  private val httpClient = SerializableHttpClient

  @Throws(Exception::class)
  suspend fun getCoinsMarketsInfo(): List<Nothing> {
    return httpClient.get() {
      url {
        protocol = URLProtocol.HTTPS
        host = BASE_URL
        pathApiV3("coins", "markets")

        parameter("vs_currency", "usd")
        parameter("order", "market_cap_desc")
        parameter("per_page", "100")
        parameter("page", "1")
        parameter("sparkline", "false")
      }
    }.body()
  }

  companion object {
    private const val BASE_URL = "api.coingecko.com"
  }
}

fun URLBuilder.pathApiV3(vararg path: String) {
  pathSegments = listOf("api", "v3") + path.toList()
}