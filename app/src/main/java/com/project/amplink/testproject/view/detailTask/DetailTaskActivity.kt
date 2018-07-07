package com.project.amplink.testproject.view.detailTask

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.BR
import com.project.amplink.testproject.appDependencies
import com.project.amplink.testproject.view.detailTask.dagger.DaggerDetailTaskComponent
import javax.inject.Inject

class DetailTaskActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDetailTaskComponent.builder()
            .activity(this)
            .appDepedencies(applicationContext.appDependencies())
            .build()
            .inject(this)

        build()
    }

    // ViewModel Setting
    private fun build() {
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, viewModel.layoutId)
        binding.setLifecycleOwner(this)
        binding.setVariable(BR.viewModel, viewModel)
    }
}
