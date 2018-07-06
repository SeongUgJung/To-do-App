package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class AddTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    var task = MutableLiveData<Task>().apply { value = Task() }

    var isTitle = MutableLiveData<Boolean>().apply{ value = false }
    var isName = MutableLiveData<Boolean>().apply { value = false }
    var isContent = MutableLiveData<Boolean>().apply { value = false }

    // Android 데이터베이스에 값을 넣는다.
    fun insertData() {
        taskRepository.insertTask(task.value!!)
    }

    // 아래 코드들은 Setter역할
    fun setIsTitle() {
        isTitle.postValue(task.value!!.title.isNotEmpty())
    }

    fun setIsName() {
        isName.postValue(task.value!!.name.isNotEmpty())
    }

    fun setIsContent() {
        isContent.postValue(task.value!!.content.isNotEmpty())
    }
}