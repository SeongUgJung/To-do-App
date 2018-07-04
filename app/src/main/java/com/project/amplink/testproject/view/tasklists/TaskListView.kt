package com.project.amplink.testproject.view.tasklists

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.project.amplink.testproject.R
import com.project.amplink.testproject.view.addtask.AddTaskView
import com.project.amplink.testproject.databinding.TasklistviewBinding
import kotlinx.android.synthetic.main.tasklistview.*

class TaskListView : AppCompatActivity() {
    private lateinit var viewModel: TaskListViewModel
    private lateinit var adapter: TaskListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.tasklistview) as TasklistviewBinding
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
        setRecyclerView()

        viewModel.tasks.observe(this, Observer {
            adapter.setTasks(it!!)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.setTasks()
    }

    private fun setRecyclerView() {
         adapter = TaskListAdapter()
        recyclerview.apply {
            adapter = this@TaskListView.adapter
            layoutManager = LinearLayoutManager(this@TaskListView)
        }
    }

    fun onButtonClicked(v: View) {
        val intent = Intent(this, AddTaskView::class.java)
        startActivity(intent)
    }
}
