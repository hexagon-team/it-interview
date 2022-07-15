package com.hexagonteam.itinterview.data.remote

import com.hexagonteam.itinterview.ktor.SerializableHttpClient

internal class ExampleRepositoryImpl(
  private val httpClient: SerializableHttpClient,
) : ExampleRepository {

  override fun exampleRequest(): List<String> {
    return emptyList()
  }
}

interface ExampleRepository {
  @Throws(Exception::class)
  fun exampleRequest(): List<String>
}