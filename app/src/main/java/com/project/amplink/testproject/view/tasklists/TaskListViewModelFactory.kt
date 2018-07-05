package com.project.amplink.testproject.view.tasklists

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.project.amplink.testproject.domain.local.TaskRepository

class TaskListViewModelFactory(
        private val taskRepository: TaskRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaskListViewModel(taskRepository) as T
    }
}