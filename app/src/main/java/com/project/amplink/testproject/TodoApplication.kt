package com.project.amplink.testproject

import android.app.Application
import android.content.Context
import com.project.amplink.testproject.dagger.AppComponent
import com.project.amplink.testproject.dagger.AppDependencies
import com.project.amplink.testproject.dagger.DaggerAppComponent


class TodoApplication : Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .app(this)
            .build()

        component.inject(this)
    }

    fun appDependencies() = component
}

fun Context.appDependencies() : AppDependencies {
    return if (this is TodoApplication) {
        this.appDependencies()
    } else {
        (applicationContext as TodoApplication).appDependencies()
    }
}