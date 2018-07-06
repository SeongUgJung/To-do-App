package com.project.amplink.testproject.view.detailTask.usecase

import android.app.Activity
import android.content.Context


interface BackToHomeUsecase {
    fun home()
}

class BackToHomeUsecaseImpl(private val context: Context) : BackToHomeUsecase{
    override fun home() {
        val activity = context as? Activity ?: return
        if (!activity.isFinishing) {
            activity.finish()
        }
    }
}