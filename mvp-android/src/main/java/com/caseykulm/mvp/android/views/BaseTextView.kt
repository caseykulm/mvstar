package com.caseykulm.mvp.android.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import com.caseykulm.mvp.presenters.BasePresenter
import com.caseykulm.mvp.presenters.ViewLifecyclePresenter
import com.caseykulm.mvp.views.BaseView

abstract class BaseTextView<P: BasePresenter>(context: Context, attributeSet: AttributeSet?): BaseView<P>, TextView(context, attributeSet) {
  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    val viewLifeCyclePresenter = presenter as ViewLifecyclePresenter
    viewLifeCyclePresenter.onAttached()
  }

  override fun onDetachedFromWindow() {
    val viewLifeCyclePresenter = presenter as ViewLifecyclePresenter
    viewLifeCyclePresenter.onDetached()
    super.onDetachedFromWindow()
  }
}