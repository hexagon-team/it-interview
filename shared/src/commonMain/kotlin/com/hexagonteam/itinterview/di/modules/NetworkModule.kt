package com.hexagonteam.itinterview.di.modules

import com.hexagonteam.itinterview.data.remote.ExampleRepository
import com.hexagonteam.itinterview.data.remote.ExampleRepositoryImpl
import com.hexagonteam.itinterview.ktor.SerializableHttpClient
import org.koin.dsl.module

internal val NetworkModule = module {
  single { SerializableHttpClient }
  single<ExampleRepository> { ExampleRepositoryImpl(get()) }
}

