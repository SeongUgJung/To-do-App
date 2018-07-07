package com.project.amplink.testproject.view.detailTask.dagger

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.project.amplink.testproject.base.viewModelFactory
import com.project.amplink.testproject.base.viewModelGet
import com.project.amplink.testproject.dagger.AppDependencies
import com.project.amplink.testproject.domain.local.TaskRepository
import com.project.amplink.testproject.util.ResourcesProvider
import com.project.amplink.testproject.util.ResourcesProviderImpl
import com.project.amplink.testproject.view.detailTask.DetailTaskActivity
import com.project.amplink.testproject.view.detailTask.DetailTaskViewModel
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecase
import com.project.amplink.testproject.view.detailTask.usecase.BackToHomeUsecaseImpl
import com.project.amplink.testproject.view.detailTask.usecase.ShowToastForDetailUsecase
import com.project.amplink.testproject.view.detailTask.usecase.ShowToastForDetailUsecaseImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DetailTaskScope


@DetailTaskScope
@Component(dependencies = [AppDependencies::class],
    modules = [DetailTaskModule::class])
interface DetailTaskComponent {

    fun inject(activity: DetailTaskActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: DetailTaskActivity): Builder

        fun appDepedencies(deps: AppDependencies): Builder
        fun build(): DetailTaskComponent
    }
}

private const val EXTRA_INDEX = "index"

@Module
object DetailTaskModule {
    @DetailTaskScope
    @Provides
    @JvmStatic
    fun viewModelFactory(taskRepository: TaskRepository,
                         showToastForDetailUsecase: ShowToastForDetailUsecase,
                         backToHomeUsecase: BackToHomeUsecase,
                         @Named(EXTRA_INDEX) taskNo: Int): ViewModelProvider.Factory = viewModelFactory {
        DetailTaskViewModel(taskRepository, showToastForDetailUsecase, backToHomeUsecase, taskNo)
    }


    @DetailTaskScope
    @Provides
    @JvmStatic
    @Named(EXTRA_INDEX)
    fun taskNo(activity: DetailTaskActivity): Int = activity.intent.getIntExtra(EXTRA_INDEX, 0)

    @DetailTaskScope
    @Provides
    @JvmStatic
    fun viewModel(factory: ViewModelProvider.Factory,
                  activity: DetailTaskActivity): DetailTaskViewModel = viewModelGet(activity, factory)

    @DetailTaskScope
    @Provides
    @JvmStatic
    fun resourcesProvider(context: Context): ResourcesProvider = ResourcesProviderImpl(context)

    @DetailTaskScope
    @Provides
    @JvmStatic
    fun showToastForDetailUsecase(context: Context, resourcesProvider: ResourcesProvider): ShowToastForDetailUsecase = ShowToastForDetailUsecaseImpl(context, resourcesProvider)

    @DetailTaskScope
    @Provides
    @JvmStatic
    fun backToHomeUsecase(activity: DetailTaskActivity): BackToHomeUsecase = BackToHomeUsecaseImpl(activity)


}