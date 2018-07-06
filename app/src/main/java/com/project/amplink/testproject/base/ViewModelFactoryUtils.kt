package com.project.amplink.testproject.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


fun <R : ViewModel> viewModelFactory(action : () -> R): ViewModelProvider.NewInstanceFactory {
    return object : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return action() as T
        }
    }
}