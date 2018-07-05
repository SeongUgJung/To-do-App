package com.project.amplink.testproject.util

import android.content.Context
import com.project.amplink.testproject.domain.local.AppDatabase
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.addtask.AddTaskViewModelFactory
import com.project.amplink.testproject.view.detailTask.DetailTaskViewModelFactory
import com.project.amplink.testproject.view.tasklists.TaskListViewModelFactory

/**
 * Repository와 viewmodelFactory 정의
 */
object InjecorUtil {
    private fun getTaskRepository(context: Context) : TaskRepository {
        return TaskRepository.getInstance(AppDatabase.getInstance(context).taskDao())
    }

    fun provideAddTaskViewModelFactory(context: Context): AddTaskViewModelFactory {
        val repository = getTaskRepository(context)
        return AddTaskViewModelFactory(repository)
    }

    fun provideDetailTaskViewModelFactory(context: Context, taskNo: Int): DetailTaskViewModelFactory {
        val repository = getTaskRepository(context)
        return DetailTaskViewModelFactory(repository, taskNo)
    }

    fun provideTaskListViewModelFactory(context: Context): TaskListViewModelFactory {
        val repository = getTaskRepository(context)
        return TaskListViewModelFactory(repository)
    }
}