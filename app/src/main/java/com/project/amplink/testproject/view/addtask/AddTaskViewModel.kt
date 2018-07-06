package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import com.project.amplink.testproject.R
import com.project.amplink.testproject.base.BaseViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.addtask.usecase.ShowToastForAddUsecase
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecase

class AddTaskViewModel(private val taskRepository: TaskRepository,
                       private val backToHomeUsecase: BackToHomeUsecase,
                       private val showToastForAddUsecase: ShowToastForAddUsecase): BaseViewModel() {

    var task = MutableLiveData<Task>().apply { value = Task() }
    var isTitle = ObservableBoolean(false)

    var isName = ObservableBoolean(false)
    var isContent = ObservableBoolean(false)
    override val layoutId: Int = R.layout.addtaskview

    // 취소 버튼 눌렀을때 실행
    fun onCancelClicked() {
        backToHomeUsecase.home()
    }

    // 추가 버튼 눌렀을때 실행
    fun onAddClicked() {
        taskRepository.insertTask(task.value!!)
        showToastForAddUsecase.uploaded()
        backToHomeUsecase.home()
    }

    // 아래 코드들은 Setter역할
    fun setIsTitle() {
        isTitle.set(task.value!!.title.isNotEmpty())
    }

    fun setIsName() {
        isName.set(task.value!!.name.isNotEmpty())
    }

    fun setIsContent() {
        isContent.set(task.value!!.content.isNotEmpty())
    }
}