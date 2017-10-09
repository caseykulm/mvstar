package com.caseykulm.mvp.views

import com.caseykulm.mvp.presenters.BasePresenter

interface BaseView<P: BasePresenter> {
  var presenter: P
}