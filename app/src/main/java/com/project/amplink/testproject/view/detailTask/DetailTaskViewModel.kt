package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class DetailTaskViewModel(private val taskRepository: TaskRepository, taskNo: Int): ViewModel() {
    var task = MutableLiveData<Task>()

    var isTitle = MutableLiveData<Boolean>()
    var isContent = MutableLiveData<Boolean>()

    // 코틀린 문법으로 init은 생성자 코드가 실행되기 전 실행되는 코드
    // Detail한 Task의 정보를 가져와 task에 저장
    init {
        setTask(taskNo)
        isTitle.postValue(false)
        isContent.postValue(false)
    }

    private fun setTask(taskNo: Int) {
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