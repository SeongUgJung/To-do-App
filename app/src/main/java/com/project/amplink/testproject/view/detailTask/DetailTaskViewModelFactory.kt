package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.project.amplink.testproject.domain.local.TaskRepository

class DetailTaskViewModelFactory(
        private val taskRepository: TaskRepository,
        private val taskNo: Int
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailTaskViewModel(taskRepository, taskNo) as T
    }
}