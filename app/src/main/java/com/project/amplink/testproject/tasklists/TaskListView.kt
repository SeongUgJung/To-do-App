package com.project.amplink.testproject.tasklists

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.project.amplink.testproject.R
import com.project.amplink.testproject.addtask.AddTaskView
import com.project.amplink.testproject.databinding.TasklistviewBinding

class TaskListView : AppCompatActivity() {
    private lateinit var viewModel: TaskListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.tasklistview) as TasklistviewBinding
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel

    }

    fun onButtonClicked(v: View) {
        val intent = Intent(this, AddTaskView::class.java)
        startActivity(intent)
    }
}
