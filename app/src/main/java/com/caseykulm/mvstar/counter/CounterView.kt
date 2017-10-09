package com.caseykulm.mvstar.counter

import android.content.Context
import android.util.AttributeSet
import com.caseykulm.mvp.presenters.BaseRxViewPresenter

class CounterView(context: Context, attributeSet: AttributeSet): CounterContract.View(context, attributeSet) {
  override lateinit var presenter: BaseRxViewPresenter

  override fun showCountText(count: String) {
    text = count
  }
}