package com.caseykulm.mvstar.di

import android.content.Context
import com.caseykulm.mvstar.App
import com.caseykulm.mvstar.data.Repository

interface AppGraph {
  companion object {
    fun get(context: Context): AppGraph {
      return (context.applicationContext as App).appGraph
    }
  }

  fun provideRepository(): Repository
}