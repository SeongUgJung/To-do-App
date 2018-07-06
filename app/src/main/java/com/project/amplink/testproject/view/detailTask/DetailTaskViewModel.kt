package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class DetailTaskViewModel(private val taskRepository: TaskRepository, taskNo: Int): ViewModel() {
    var task = MutableLiveData<Task>().apply { value = taskRepository.getTask(taskNo) }

    var isTitle = MutableLiveData<Boolean>().apply { value = true }
    var isContent = MutableLiveData<Boolean>().apply { value = true }

    fun updateTask() {
        taskRepository.updateTask(task.value!!)
    }

    fun deleteTask() {
        taskRepository.deleteTask(task.value!!)
    }

    fun setIsTitle() {
        isTitle.postValue(task.value!!.title.isNotEmpty())
    }

    fun setIsContent() {
        isContent.postValue(task.value!!.content.isNotEmpty())
    }
}