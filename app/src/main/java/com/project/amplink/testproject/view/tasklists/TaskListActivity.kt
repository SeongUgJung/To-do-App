package com.project.amplink.testproject.view.tasklists

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.project.amplink.testproject.BR
import com.project.amplink.testproject.appDependencies
import com.project.amplink.testproject.view.tasklists.dagger.DaggerTaskListComponent
import javax.inject.Inject

class TaskListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: TaskListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTaskListComponent.builder()
            .activity(this)
            .appDepedencies(applicationContext.appDependencies())
            .build()
            .inject(this)

        build()
    }

    private fun build() {
        // can make template
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, viewModel.layoutId)
        binding.setLifecycleOwner(this)
        binding.setVariable(BR.viewModel, viewModel)
    }


}
