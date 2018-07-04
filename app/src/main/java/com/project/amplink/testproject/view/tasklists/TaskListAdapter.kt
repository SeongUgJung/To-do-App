package com.project.amplink.testproject.view.tasklists

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.amplink.testproject.R
import com.project.amplink.testproject.view.detailTask.DetailTaskView
import com.project.amplink.testproject.domain.Task
import kotlinx.android.synthetic.main.tasklistitem.view.*

class TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    private var tasks = mutableListOf<Task>()

    fun setTasks(tasks: MutableList<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasklistitem, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.itemView.textView.text = task.no.toString()
        holder.itemView.textView2.text = task.title

        holder.itemView.stage.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailTaskView::class.java)
            intent.putExtra("index", task.no)
            holder.itemView.context.startActivity(intent)
        }
    }



    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}