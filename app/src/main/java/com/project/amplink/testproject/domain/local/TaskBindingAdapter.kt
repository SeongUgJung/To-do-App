package com.project.amplink.testproject.domain.local

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.view.tasklists.TaskListAdapter


@BindingAdapter("tools:bind")
fun bindItem(recyclerView: RecyclerView, tasks: MutableLiveData<MutableList<Task>>?) {
    if(tasks!!.value == null) {
        return
    }
    (recyclerView.adapter as TaskListAdapter).setTasks(tasks.value!!)
}