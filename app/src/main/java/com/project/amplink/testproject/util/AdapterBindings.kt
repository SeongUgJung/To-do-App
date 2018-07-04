package com.project.amplink.testproject.util

import android.support.v7.widget.RecyclerView
import android.databinding.BindingAdapter
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.view.tasklists.TaskListAdapter


object AdapterBindings {
    @BindingAdapter("tools:item") @JvmStatic
    fun bindItem(recyclerView: RecyclerView, tasks: MutableList<Task>) {
        (recyclerView.adapter as TaskListAdapter).setTasks(tasks)
    }
}