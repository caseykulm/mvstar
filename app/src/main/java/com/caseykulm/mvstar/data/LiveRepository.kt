package com.caseykulm.mvstar.data

import com.f2prateek.rx.preferences2.RxSharedPreferences

class LiveRepository(val rxPrefs: RxSharedPreferences): Repository {
  override fun putCount(count: Int) = rxPrefs.getInteger("pref_count").set(count)
  override fun getCount() = rxPrefs.getInteger("pref_count").asObservable()
}