package com.project.amplink.testproject.view.tasklists.usecase

import android.content.Context
import android.content.Intent
import com.project.amplink.testproject.view.addtask.AddTaskActivity


interface CallAddTaskUsecase {
    fun showAddTaskScreen()
}

class CallAddTaskUsecaseImpl(private val context: Context) : CallAddTaskUsecase {
    override fun showAddTaskScreen() {
        val intent = Intent(context, AddTaskActivity::class.java)
        context.startActivity(intent)

    }
}