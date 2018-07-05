package com.project.amplink.testproject.view.tasklists

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.amplink.testproject.BR
import com.project.amplink.testproject.databinding.TasklistitemBinding
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.view.detailTask.DetailTaskActivity
import kotlinx.android.synthetic.main.tasklistitem.view.*

class TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    private var tasks = listOf<Task>()

    fun setTasks(tasks: List<Task>) {
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
    }



    class ViewHolder(private val binding: TasklistitemBinding):RecyclerView.ViewHolder(binding.root) {
        var task: Task? = null

        init {
            itemView.stage.setOnClickListener {
                val intent = Intent(itemView.context, DetailTaskActivity::class.java)
                intent.putExtra("index", task!!.no)
                itemView.context.startActivity(intent)
            }
        }

        fun bind(task: Task) {
            this.task = task
            binding.setVariable(BR.task, task)
        }
    }
}