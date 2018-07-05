package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository

class AddTaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    var task: MutableLiveData<Task> = MutableLiveData()

    var isTitle: MutableLiveData<Boolean> = MutableLiveData()
    var isName: MutableLiveData<Boolean> = MutableLiveData()
    var isContent: MutableLiveData<Boolean> = MutableLiveData()

    // 코틀린 문법으로 init은 생성자 코드가 실행되기 전 실행되는 코드
    init {
        task.postValue(Task(0, "", "", ""))

        isTitle.postValue(false)
        isName.postValue(false)
        isContent.postValue(false)
    }

    // Android 데이터베이스에 값을 넣는다.
    fun insertData(onSuccess: () -> Unit) {
        taskRepository.insertTask(task.value!!, onSuccess)
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