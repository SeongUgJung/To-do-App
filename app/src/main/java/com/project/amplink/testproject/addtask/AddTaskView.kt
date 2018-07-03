package com.project.amplink.testproject.addtask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.amplink.testproject.R
import com.project.amplink.testproject.databinding.AddtaskviewBinding

class AddTaskView : AppCompatActivity(){
    private lateinit var viewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.addtaskview) as AddtaskviewBinding
        viewModel = ViewModelProviders.of(this).get(AddTaskViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
    }

    fun onCancelClicked(v: View) {
        finish()
    }

    fun onAddClicked(v:View) {
        viewModel.insertData()
        Toast.makeText(this, "올렸습니다.", Toast.LENGTH_LONG).show()
        finish()
    }
}
