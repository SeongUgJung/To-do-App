package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import com.project.amplink.testproject.R
import com.project.amplink.testproject.base.BaseViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecase
import com.project.amplink.testproject.view.detailTask.usecase.ShowToastForDetailUsecase

class DetailTaskViewModel(private val taskRepository: TaskRepository,
                          private val showToastForDetailUsecase: ShowToastForDetailUsecase,
                          private val backToHomeUsecase: BackToHomeUsecase,
                          taskNo: Int) : BaseViewModel() {
    var task = MutableLiveData<Task>().apply { value = taskRepository.getTask(taskNo) }
    override val layoutId: Int = R.layout.detailtaskview


    var isTitle = ObservableBoolean(true)
    var isContent = ObservableBoolean(true)

    fun updateTask() {
        showToastForDetailUsecase.update()
        taskRepository.updateTask(task.value!!)
        backToHomeUsecase.home()
    }

    fun deleteTask() {
        showToastForDetailUsecase.delete()
        taskRepository.deleteTask(task.value!!)
        backToHomeUsecase.home()
    }

    fun setIsTitle() {
        isTitle.set(task.value!!.title.isNotEmpty())
    }

    fun setIsContent() {
        isContent.set(task.value!!.content.isNotEmpty())
    }
}