package com.project.amplink.testproject.dagger

import android.content.Context
import com.project.amplink.testproject.TodoApplication
import com.project.amplink.testproject.domain.local.RepositoryModule
import com.project.amplink.testproject.domain.local.TaskRepository
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@AppScope
@Component(modules = [
    AppModule::class,
    RepositoryModule::class
])
interface AppComponent : AppDependencies {

    fun inject(app: TodoApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: TodoApplication): Builder

        fun build(): AppComponent
    }
}

@Module
object AppModule {
    @AppScope
    @Provides
    @JvmStatic
    fun context(app: TodoApplication): Context = app
}

interface AppDependencies {
    fun context() : Context
    fun taskRepository() : TaskRepository
}