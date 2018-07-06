package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.databinding.DetailtaskviewBinding
import com.project.amplink.testproject.util.InjecorUtil

class DetailTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        build()
    }

    // ViewModel Setting
    private fun build() {
        val factory = InjecorUtil.provideDetailTaskViewModelFactory(this, intent.getIntExtra("index", 0))
        val viewModel = ViewModelProviders.of(this, factory).get(DetailTaskViewModel::class.java)
        val binding = DataBindingUtil.setContentView(this, viewModel.layoutId) as DetailtaskviewBinding
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }
}
