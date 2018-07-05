package com.project.amplink.testproject.view.addtask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.amplink.testproject.R
import com.project.amplink.testproject.databinding.AddtaskviewBinding
import com.project.amplink.testproject.util.InjecorUtil

class AddTaskActivity : AppCompatActivity(){
    private lateinit var viewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        setBinding()
    }

    // ViewModel Setting
    private fun setViewModel() {
        val factory = InjecorUtil.provideAddTaskViewModelFactory(this)
        viewModel = ViewModelProviders.of(this, factory).get(AddTaskViewModel::class.java)
    }

    // DataBinding Setting
    private fun setBinding() {
        val binding = DataBindingUtil.setContentView(this, R.layout.addtaskview) as AddtaskviewBinding
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
    }

    // 취소 버튼 눌렀을때 실행
    fun onCancelClicked(v: View) {
        finish()
    }

    // 추가 버튼 눌렀을때 실행
    fun onAddClicked(v:View) {
        viewModel.insertData{
            Toast.makeText(this, "올렸습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
