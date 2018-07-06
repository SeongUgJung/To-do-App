package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.databinding.AddtaskviewBinding
import com.project.amplink.testproject.util.InjecorUtil

class AddTaskActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
    }

    // ViewModel Setting
    private fun setViewModel() {
        val factory = InjecorUtil.provideAddTaskViewModelFactory(this)
        val viewModel = ViewModelProviders.of(this, factory).get(AddTaskViewModel::class.java)
        val binding = DataBindingUtil.setContentView(this, viewModel.layoutId) as AddtaskviewBinding
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }

}
