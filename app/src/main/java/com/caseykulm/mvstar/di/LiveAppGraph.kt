package com.caseykulm.mvstar.di

import android.content.Context
import android.preference.PreferenceManager
import com.caseykulm.mvstar.data.LiveRepository
import com.caseykulm.mvstar.data.Repository
import com.f2prateek.rx.preferences2.RxSharedPreferences

class LiveAppGraph(appContext: Context): AppGraph {
  val repository: Repository

  init {
    val prefs = PreferenceManager.getDefaultSharedPreferences(appContext)
    val rxPrefs = RxSharedPreferences.create(prefs)
    repository = LiveRepository(rxPrefs)
  }

  override fun provideRepository() = repository
}