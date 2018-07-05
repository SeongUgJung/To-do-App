package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class AddTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    var task: MutableLiveData<Task> = MutableLiveData()

    var isTitle: MutableLiveData<Boolean> = MutableLiveData()
    var isName: MutableLiveData<Boolean> = MutableLiveData()
    var isContent: MutableLiveData<Boolean> = MutableLiveData()

    init {
        task.postValue(Task(0, "", "", ""))

        isTitle.postValue(false)
        isName.postValue(false)
        isContent.postValue(false)
    }

    fun insertData(onSuccess: () -> Unit) {
        taskRepository.insertTask(task.value!!, onSuccess)
    }

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