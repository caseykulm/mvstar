package com.caseykulm.mvstar.counter

import com.caseykulm.mvp.presenters.BaseRxViewPresenter
import com.caseykulm.mvstar.data.Repository
import io.reactivex.Observable

class CounterPresenter(
  val view: CounterContract.View,
  val plusClickStream: Observable<Any>,
  val minusClickStream: Observable<Any>,
  val repository: Repository) : BaseRxViewPresenter() {
  /**
   * The singular reason for this presenter to change state
   */
  private var currentCount = 0

  init {
    addIntentToModelBindings()
  }

  override fun onAttached() {
    super.onAttached()
    addModelToViewBindings()
  }

  /**
   * Update the view with the current state of the presenter
   */
  private fun updateView() {
    view.showCountText(currentCount.toString())
  }

  /**
   * Update the model with the current state of the presenter
   */
  private fun updateModel() {
    repository.putCount(currentCount)
  }

  /**
   * Define how model changes should update the view
   */
  private fun addModelToViewBindings() {
    val viewDisp = repository.getCount()
      .subscribe {
        currentCount = it
        updateView()
      }
    addDisposable(viewDisp)
  }

  /**
   * Define how user interactions with the UI update the model
   */
  private fun addIntentToModelBindings() {
    plusClickStream
      .subscribe {
        currentCount++
        updateModel()
      }
    minusClickStream
      .subscribe {
        currentCount--
        updateModel()
      }
  }
}