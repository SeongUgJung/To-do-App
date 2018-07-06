package com.project.amplink.testproject.view.addtask.usecase

import android.content.Context
import com.project.amplink.testproject.R
import com.project.amplink.testproject.util.ResourcesProvider
import com.project.amplink.testproject.util.toast


interface ShowToastForAddUsecase {
    fun uploaded()
}


class ShowToastForAddUsecaseImpl(private val context: Context,
                                 private val resourcesProvider: ResourcesProvider) : ShowToastForAddUsecase {
    override fun uploaded() {
        context.toast(resourcesProvider.string(R.string.uploaded_completely))
    }
}
