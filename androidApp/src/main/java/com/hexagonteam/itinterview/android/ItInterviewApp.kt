package com.hexagonteam.itinterview.android

import android.app.Application
import com.hexagonteam.itinterview.android.di.modules.AndroidModule
import com.hexagonteam.itinterview.di.modules.SharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ItInterviewApp : Application() {
  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@ItInterviewApp)
      androidLogger()

      modules(AndroidModule + SharedModule)
    }
  }
}