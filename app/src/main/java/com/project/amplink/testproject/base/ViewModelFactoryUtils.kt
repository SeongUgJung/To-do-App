package com.project.amplink.testproject.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity


fun viewModelFactory(action: () -> Any): ViewModelProvider.NewInstanceFactory {
    return object : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return action() as T
        }
    }
}

inline fun <reified T : ViewModel> viewModelGet(activity: FragmentActivity, factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(activity, factory).get(T::class.java)
}