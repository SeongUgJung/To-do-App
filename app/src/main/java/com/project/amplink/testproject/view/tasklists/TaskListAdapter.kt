package com.project.amplink.testproject.view.tasklists

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.amplink.testproject.BR
import com.project.amplink.testproject.databinding.TasklistitemBinding
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.view.detailTask.DetailTaskView
import kotlinx.android.synthetic.main.tasklistitem.view.*

class TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    private var tasks = mutableListOf<Task>()

    fun setTasks(tasks: MutableList<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TasklistitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
        holder.itemView.stage.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailTaskView::class.java)
            intent.putExtra("index", task.no)
            holder.itemView.context.startActivity(intent)
        }
    }



    class ViewHolder(private val binding: TasklistitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.setVariable(BR.task, task)
        }
    }
}