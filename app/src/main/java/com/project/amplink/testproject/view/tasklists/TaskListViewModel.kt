package com.project.amplink.testproject.view.tasklists

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class TaskListViewModel(private val taskRepository: TaskRepository): ViewModel() {
    var tasks: LiveData<MutableList<Task>>? = null

    init {
        tasks = taskRepository.getAll()
    }
}