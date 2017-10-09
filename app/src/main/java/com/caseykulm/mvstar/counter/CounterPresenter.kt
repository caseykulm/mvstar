package com.caseykulm.mvstar.counter

import com.caseykulm.mvp.presenters.BaseRxViewPresenter
import com.caseykulm.mvstar.data.Repository
import io.reactivex.Observable

class CounterPresenter(
  val view: CounterContract.View,
  plusClickStream: Observable<Any>,
  minusClickStream: Observable<Any>,
  val repository: Repository) : BaseRxViewPresenter() {
  var currentCount = 0

  init {
    plusClickStream
      .subscribe {
        currentCount++
        saveCurrentCount()
      }
    minusClickStream
      .subscribe {
        currentCount--
        saveCurrentCount()
      }
  }

  override fun onAttached() {
    super.onAttached()
    val viewDisp = repository.getCount()
      .subscribe {
        currentCount = it
        updateView()
      }
    addDisposable(viewDisp)
  }

  private fun updateView() {
    view.showCountText(currentCount.toString())
  }

  private fun saveCurrentCount() {
    repository.putCount(currentCount)
  }
}