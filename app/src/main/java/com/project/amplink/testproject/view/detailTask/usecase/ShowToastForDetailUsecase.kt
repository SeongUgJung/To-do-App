package com.project.amplink.testproject.view.detailTask.usecase

import android.content.Context
import com.project.amplink.testproject.R
import com.project.amplink.testproject.util.ResourcesProvider
import com.project.amplink.testproject.util.toast


interface ShowToastForDetailUsecase {
    fun update()
    fun delete()
}

class ShowToastForDetailUsecaseImpl(private val context: Context,
                                    private val resourcesProvider: ResourcesProvider) : ShowToastForDetailUsecase {
    override fun update() {
        context.toast(resourcesProvider.string(R.string.updated_completely))
    }

    override fun delete() {
        context.toast(resourcesProvider.string(R.string.deleted_completely))
    }
}