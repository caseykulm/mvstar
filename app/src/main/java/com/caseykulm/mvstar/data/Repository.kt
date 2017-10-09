package com.caseykulm.mvstar.data

import io.reactivex.Observable

interface Repository {
  fun putCount(count: Int)
  fun getCount(): Observable<Int>
}