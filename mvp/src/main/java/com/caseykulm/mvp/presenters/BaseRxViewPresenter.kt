package com.caseykulm.mvp.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseRxViewPresenter: BasePresenter, RxPresenter, ViewLifecyclePresenter {
  val compositeDisposable = CompositeDisposable()

  override fun subscribe() {

  }

  override fun onAttached() {

  }

  override fun unsubscribe() {

  }

  override fun onDetached() {
    compositeDisposable.clear()
  }

  protected fun addDisposable(disposable: Disposable) {
    compositeDisposable.add(disposable)
  }
}