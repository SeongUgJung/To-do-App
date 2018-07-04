package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.amplink.testproject.R
import com.project.amplink.testproject.databinding.DetailtaskviewBinding

class DetailTaskView : AppCompatActivity() {
    private lateinit var viewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView(this, R.layout.detailtaskview) as DetailtaskviewBinding
        viewModel = ViewModelProviders.of(this).get(DetailTaskViewModel::class.java)
        viewModel.setTask(intent.getIntExtra("index", 0))
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
    }

    fun onUpdateClicked(v: View) {
        viewModel.updateTask {
            Toast.makeText(this, "업데이트 완료 했습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    fun onDeleteClicked(v: View) {
        viewModel.deleteTask {
            Toast.makeText(this, "삭제 완료 했습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
