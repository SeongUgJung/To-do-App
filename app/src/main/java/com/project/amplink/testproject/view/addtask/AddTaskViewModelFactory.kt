package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.project.amplink.testproject.domain.local.TaskRepository

/**
 *  ViewModel을 생성하기 위한 Factory
 */
class AddTaskViewModelFactory(
        private val taskRepository: TaskRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddTaskViewModel(taskRepository) as T
    }
}