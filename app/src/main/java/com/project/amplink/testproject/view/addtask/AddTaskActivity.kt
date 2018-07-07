package com.project.amplink.testproject.view.addtask

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.BR
import com.project.amplink.testproject.appDependencies
import com.project.amplink.testproject.view.addtask.dagger.DaggerAddTaskComponent
import javax.inject.Inject

class AddTaskActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: AddTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAddTaskComponent.builder()
            .activity(this)
            .appDepedencies(applicationContext.appDependencies())
            .build()
            .inject(this)


        setViewModel()
    }

    // ViewModel Setting
    private fun setViewModel() {
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, viewModel.layoutId)
        binding.setLifecycleOwner(this)
        binding.setVariable(BR.viewModel, viewModel)
    }

}
