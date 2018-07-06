package com.project.amplink.testproject.util

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.view.tasklists.TaskListAdapter


@BindingAdapter("taskListAdapter")
fun taskListAdapter(recyclerview: RecyclerView, list: List<Task>) {

    val adapter: TaskListAdapter = recyclerview.adapter as? TaskListAdapter
        ?: TaskListAdapter().apply { recyclerview.adapter = this }
    recyclerview.apply {
        layoutManager = LinearLayoutManager(recyclerview.context)
    }

    adapter.setTasks(list)
}

@BindingAdapter("android:visibility")
fun visibility(view : View, visible : Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}