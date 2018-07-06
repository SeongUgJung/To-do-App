package com.project.amplink.testproject.util

import android.content.Context
import android.support.annotation.DimenRes
import android.support.annotation.StringRes


interface ResourcesProvider {
    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: String): String
    fun dimen(@DimenRes id: Int): Float
}

class ResourcesProviderImpl(context: Context) : ResourcesProvider {
    private val resources = context.resources
    override fun string(@StringRes id: Int) = resources.getString(id)
    override fun string(@StringRes id: Int, vararg args: String) = resources.getString(id, args)
    override fun dimen(@DimenRes id: Int) = resources.getDimension(id)
}