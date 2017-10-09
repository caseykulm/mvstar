package com.caseykulm.mvstar.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.caseykulm.mvstar.R
import com.caseykulm.mvstar.di.AppGraph
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_main.*

class CounterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val plusClicks = RxView.clicks(plusButton)
    val minusClicks = RxView.clicks(minusButton)
    val presenter = CounterPresenter(counterView, plusClicks, minusClicks, AppGraph.get(this).provideRepository())
    counterView.presenter = presenter
  }
}
