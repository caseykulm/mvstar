package com.caseykulm.mvstar.counter

import android.preference.PreferenceManager
import android.support.test.InstrumentationRegistry
import com.caseykulm.mvp.presenters.BaseRxViewPresenter
import com.caseykulm.mvstar.data.LiveRepository
import com.f2prateek.rx.preferences2.RxSharedPreferences
import io.reactivex.subjects.BehaviorSubject
import org.junit.Before
import org.junit.Test

class CounterViewTestAndroid {
  val counterView = object : CounterContract.View(InstrumentationRegistry.getContext(), null) {
    lateinit var setPres: BaseRxViewPresenter

    override var presenter: BaseRxViewPresenter
      get() = setPres
      set(value) { setPres = value }

    override fun showCountText(count: String) {
      // no-op
    }
  }
  val rxPrefs: RxSharedPreferences by lazy {
    val prefs = PreferenceManager.getDefaultSharedPreferences(InstrumentationRegistry.getTargetContext())
    RxSharedPreferences.create(prefs)
  }
  val repository = LiveRepository(rxPrefs)
  val plusClickStream = BehaviorSubject.create<Any>()
  val minusClickStream = BehaviorSubject.create<Any>()
  val counterPresenter: CounterPresenter by lazy { CounterPresenter(counterView, plusClickStream, minusClickStream, repository) }

  @Before
  fun setup() {
    // arrange
    counterView.presenter = counterPresenter
    repository.putCount(0)
  }

  @Test
  fun plusTapsShouldIncrementCount() {
    // arrange

    // act
    plusClickStream.onNext("")
    plusClickStream.onNext("")
    plusClickStream.onNext("")

    // assert
    repository.getCount().test()
      .assertNoErrors()
      .assertValue(3)
  }

  @Test
  fun minusTapsShouldDecrementCount() {
    // arrange

    // act
    minusClickStream.onNext("")
    minusClickStream.onNext("")

    // assert
    repository.getCount().test()
      .assertNoErrors()
      .assertValue(-2)
  }
}