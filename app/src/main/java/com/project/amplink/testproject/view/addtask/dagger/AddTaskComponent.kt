package com.project.amplink.testproject.view.addtask.dagger

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.project.amplink.testproject.base.viewModelFactory
import com.project.amplink.testproject.base.viewModelGet
import com.project.amplink.testproject.dagger.AppDependencies
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.util.ResourcesProvider
import com.project.amplink.testproject.util.ResourcesProviderImpl
import com.project.amplink.testproject.view.addtask.AddTaskActivity
import com.project.amplink.testproject.view.addtask.AddTaskViewModel
import com.project.amplink.testproject.view.addtask.usecase.ShowToastForAddUsecase
import com.project.amplink.testproject.view.addtask.usecase.ShowToastForAddUsecaseImpl
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecase
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecaseImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AddTaskScope


@AddTaskScope
@Component(dependencies = [AppDependencies::class],
    modules = [AddTaskModule::class])
interface AddTaskComponent {

    fun inject(activity: AddTaskActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: AddTaskActivity): Builder

        fun appDepedencies(deps: AppDependencies): Builder
        fun build(): AddTaskComponent
    }
}

@Module
object AddTaskModule {
    @AddTaskScope
    @Provides
    @JvmStatic
    fun viewModelFactory(taskRepository: TaskRepository,
                         showToastForAddUsecase: ShowToastForAddUsecase,
                         backToHomeUsecase: BackToHomeUsecase): ViewModelProvider.Factory = viewModelFactory {
        AddTaskViewModel(taskRepository, backToHomeUsecase, showToastForAddUsecase)
    }

    @AddTaskScope
    @Provides
    @JvmStatic
    fun viewModel(factory: ViewModelProvider.Factory,
                  activity: AddTaskActivity): AddTaskViewModel = viewModelGet(activity, factory)

    @AddTaskScope
    @Provides
    @JvmStatic
    fun resourcesProvider(context: Context): ResourcesProvider = ResourcesProviderImpl(context)

    @AddTaskScope
    @Provides
    @JvmStatic
    fun showToastForAddUsecase(context: Context, resourcesProvider: ResourcesProvider): ShowToastForAddUsecase = ShowToastForAddUsecaseImpl(context, resourcesProvider)

    @AddTaskScope
    @Provides
    @JvmStatic
    fun backToHomeUsecase(activity: AddTaskActivity): BackToHomeUsecase = BackToHomeUsecaseImpl(activity)


}