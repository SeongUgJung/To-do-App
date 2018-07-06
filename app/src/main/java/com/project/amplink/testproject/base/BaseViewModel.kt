package com.project.amplink.testproject.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {
    abstract val layoutId : Int
}

abstract class RxViewModel : BaseViewModel() {

    val disposables = CompositeDisposable()

    fun Disposable.bindUtilDestroy() {
        disposables.add(this)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}