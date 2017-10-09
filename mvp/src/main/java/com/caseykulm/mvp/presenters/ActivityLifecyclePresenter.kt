package com.caseykulm.mvp.presenters

interface ActivityLifecyclePresenter {
  fun onSaveInstanceState()
  fun onRestoreInstanceState()
  fun onStart()
  fun onResume()
  fun onPause()
  fun onStop()
}