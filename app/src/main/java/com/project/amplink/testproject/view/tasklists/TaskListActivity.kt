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
import com.project.amplink.testproject.view.addtask.AddTaskActivity
import com.project.amplink.testproject.databinding.TasklistviewBinding
import com.project.amplink.testproject.util.InjecorUtil
import kotlinx.android.synthetic.main.tasklistview.*

class TaskListActivity : AppCompatActivity() {
    private lateinit var viewModel: TaskListViewModel
    private lateinit var adapter: TaskListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        setDataBinding()
        setRecyclerView()
    }

    private fun setViewModel() {
        val factory = InjecorUtil.provideTaskListViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, factory).get(TaskListViewModel::class.java)
    }

    private fun setDataBinding() {
        val binding = DataBindingUtil.setContentView(this, R.layout.tasklistview) as TasklistviewBinding
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
    }

    private fun setRecyclerView() {
         adapter = TaskListAdapter()
        recyclerview.apply {
            adapter = this@TaskListActivity.adapter
            layoutManager = LinearLayoutManager(this@TaskListActivity)
        }
        viewModel.tasks!!.observe(this, Observer {
            adapter.setTasks(it!!)
        })
    }

    fun onButtonClicked(v: View) {
        val intent = Intent(this, AddTaskActivity::class.java)
        startActivity(intent)
    }
}
