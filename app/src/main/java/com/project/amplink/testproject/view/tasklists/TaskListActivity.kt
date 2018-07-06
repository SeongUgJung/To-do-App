package com.project.amplink.testproject.view.tasklists

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.databinding.TasklistviewBinding
import com.project.amplink.testproject.util.InjecorUtil

class TaskListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        build()
    }

    private fun build() {
        val factory = InjecorUtil.provideTaskListViewModelFactory(this)
        val viewModel = ViewModelProviders.of(this, factory).get(TaskListViewModel::class.java)

        val binding = DataBindingUtil.setContentView<TasklistviewBinding>(this, viewModel.layoutId)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }


}
