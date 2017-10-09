package com.caseykulm.mvstar.data

import io.reactivex.Observable

/**
 * Abstracts away, where data comes from, and where data is stored.
 */
interface Repository {
  fun putCount(count: Int)
  fun getCount(): Observable<Int>
}