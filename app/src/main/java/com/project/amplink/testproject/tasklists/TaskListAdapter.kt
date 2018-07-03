package com.project.amplink.testproject.tasklists

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.amplink.testproject.R
import com.project.amplink.testproject.domain.Task

class TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    var tasks: List<Task> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasklistitem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }



    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}