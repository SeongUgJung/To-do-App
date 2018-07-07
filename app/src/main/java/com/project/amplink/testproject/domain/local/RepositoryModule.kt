package com.project.amplink.testproject.domain.local

import android.content.Context
import com.project.amplink.testproject.dagger.AppScope
import dagger.Module
import dagger.Provides


@Module
object RepositoryModule {
    @AppScope
    @Provides
    @JvmStatic
    fun taskDao(context: Context) = AppDatabase.getInstance(context).taskDao()

    @AppScope
    @Provides
    @JvmStatic
    fun taskRepository(taskDao: TaskDao): TaskRepository = TaskRepository(taskDao)
}