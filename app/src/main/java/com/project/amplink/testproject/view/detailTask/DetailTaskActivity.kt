package com.project.amplink.testproject.view.detailTask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.project.amplink.testproject.R
import com.project.amplink.testproject.databinding.DetailtaskviewBinding
import com.project.amplink.testproject.util.InjecorUtil

class DetailTaskActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        setDataBinding()
    }

    // ViewModel Setting
    private fun setViewModel() {
        val factory = InjecorUtil.provideDetailTaskViewModelFactory(this, intent.getIntExtra("index", 0))
        viewModel = ViewModelProviders.of(this, factory).get(DetailTaskViewModel::class.java)
    }

    // DataBinding Setting
    private fun setDataBinding() {
        val binding = DataBindingUtil.setContentView(this, R.layout.detailtaskview) as DetailtaskviewBinding
        binding.setLifecycleOwner(this)
        binding.viewModel = this.viewModel
    }

    // 업데이트 버튼 클릭 시 실행
    fun onUpdateClicked(v: View) {
        viewModel.updateTask {
            Toast.makeText(this, "업데이트 완료 했습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    // 삭제 버튼 클릭 시 실행
    fun onDeleteClicked(v: View) {
        viewModel.deleteTask {
            Toast.makeText(this, "삭제 완료 했습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
