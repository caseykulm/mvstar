package com.caseykulm.mvstar.counter

import android.content.Context
import android.util.AttributeSet
import com.caseykulm.mvp.android.views.BaseTextView
import com.caseykulm.mvp.presenters.BaseRxViewPresenter

interface CounterContract {
  abstract class View(context: Context, attributeSet: AttributeSet?): BaseTextView<BaseRxViewPresenter>(context, attributeSet) {
    abstract fun showCountText(count: String)
  }
}