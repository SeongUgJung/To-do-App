package com.project.amplink.testproject.util

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.project.amplink.testproject.base.viewModelFactory
import com.project.amplink.testproject.domain.local.AppDatabase
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.addtask.AddTaskViewModelFactory
import com.project.amplink.testproject.view.detailTask.DetailTaskViewModelFactory
import com.project.amplink.testproject.view.tasklists.TaskListViewModel
import com.project.amplink.testproject.view.tasklists.usecase.CallAddTaskUsecaseImpl

/**
 * Repository와 viewmodelFactory 정의
 */
object InjecorUtil {
    private fun getTaskRepository(context: Context): TaskRepository {
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

    fun provideTaskListViewModelFactory(context: Context): ViewModelProvider.NewInstanceFactory {
        val repository = getTaskRepository(context)
        val callAddTaskUsecase = CallAddTaskUsecaseImpl(context)
        return viewModelFactory {
            TaskListViewModel(callAddTaskUsecase, repository)
        }
    }
}