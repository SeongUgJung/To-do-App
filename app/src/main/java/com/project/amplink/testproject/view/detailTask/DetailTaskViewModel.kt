package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class DetailTaskViewModel(private val taskRepository: TaskRepository, taskNo: Int): ViewModel() {
    var task = MutableLiveData<Task>()

    var isTitle = MutableLiveData<Boolean>()
    var isContent = MutableLiveData<Boolean>()

    init {
        setTask(taskNo)
        isTitle.postValue(false)
        isContent.postValue(false)
    }

    fun setTask(taskNo: Int) {
        taskRepository.getTask(taskNo) {
            task.postValue(it)
        }
    }

    fun updateTask(onSuccess: () -> Unit) {
        taskRepository.updateTask(task.value!!, onSuccess)
    }

    fun deleteTask(onSuccess: () -> Unit) {
        taskRepository.deleteTask(task.value!!, onSuccess)
    }

    fun setIsTitle() {
        isTitle.postValue(task.value!!.title.isNotEmpty())
    }

    fun setIsContent() {
        isContent.postValue(task.value!!.content.isNotEmpty())
    }
}