package com.project.amplink.testproject.view.tasklists

import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import com.project.amplink.testproject.R
import com.project.amplink.testproject.base.RxViewModel
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.tasklists.usecase.CallAddTaskUsecase

class TaskListViewModel(private val callAddTaskUsecase: CallAddTaskUsecase,
                        taskRepository: TaskRepository) : RxViewModel() {
    var tasks: ObservableArrayList<Task> = ObservableArrayList()
    val recyclerVisible = ObservableBoolean(false)

    init {
        taskRepository.getAllRx()
            .subscribe {
                recyclerVisible.set(!it.isEmpty())

                tasks.clear()
                tasks.addAll(it)
            }
            .bindUtilDestroy()
    }

    override val layoutId: Int = R.layout.tasklistview

    fun onButtonClicked() {
        callAddTaskUsecase.showAddTaskScreen()
    }

}
