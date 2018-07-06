package com.project.amplink.testproject.view.detailTask.usecase

import android.content.Context
import com.project.amplink.testproject.R
import com.project.amplink.testproject.util.ResourcesProviderImpl
import com.project.amplink.testproject.util.toast


interface ShowToastUsecase {
    fun update()
    fun delete()
}

class ShowToastUsecaseImpl(private val context: Context,
                           private val resourcesProviderImpl: ResourcesProviderImpl) : ShowToastUsecase {
    override fun update() {
        context.toast(resourcesProviderImpl.string(R.string.updated_completely))
    }

    override fun delete() {
        context.toast(resourcesProviderImpl.string(R.string.deleted_completely))
    }
}