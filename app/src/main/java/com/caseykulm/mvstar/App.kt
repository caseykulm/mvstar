package com.caseykulm.mvstar

import android.app.Application
import com.caseykulm.mvstar.di.AppGraph
import com.caseykulm.mvstar.di.LiveAppGraph

class App: Application() {
  val appGraph: AppGraph by lazy { LiveAppGraph(this) }

  override fun onCreate() {
    super.onCreate()
  }
}