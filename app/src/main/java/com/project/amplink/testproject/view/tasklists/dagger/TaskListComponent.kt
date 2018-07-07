package com.project.amplink.testproject.view.tasklists.dagger

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.project.amplink.testproject.base.viewModelFactory
import com.project.amplink.testproject.base.viewModelGet
import com.project.amplink.testproject.dagger.AppDependencies
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.view.tasklists.TaskListActivity
import com.project.amplink.testproject.view.tasklists.TaskListViewModel
import com.project.amplink.testproject.view.tasklists.usecase.CallAddTaskUsecase
import com.project.amplink.testproject.view.tasklists.usecase.CallAddTaskUsecaseImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class TaskListScope


@TaskListScope
@Component(dependencies = [AppDependencies::class],
    modules = [TaskListModule::class])
interface TaskListComponent {

    fun inject(activity : TaskListActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: TaskListActivity) : Builder
        fun appDepedencies(deps:AppDependencies) : Builder
        fun build() : TaskListComponent
    }
}

@Module
object TaskListModule {
    @TaskListScope
    @Provides
    @JvmStatic
    fun viewModelFactory(CallAddTaskUsecase: CallAddTaskUsecase, taskRepository: TaskRepository) : ViewModelProvider.Factory = viewModelFactory {
        TaskListViewModel(CallAddTaskUsecase, taskRepository)
    }

    @TaskListScope
    @Provides
    @JvmStatic
    fun viewModel(factory : ViewModelProvider.Factory,
                  activity: TaskListActivity) : TaskListViewModel
        = viewModelGet(activity, factory)

    @TaskListScope
    @Provides
    @JvmStatic
    fun callAddTaskUsecase(context: Context) : CallAddTaskUsecase = CallAddTaskUsecaseImpl(context)
}