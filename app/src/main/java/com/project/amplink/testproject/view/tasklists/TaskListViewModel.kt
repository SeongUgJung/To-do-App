package com.project.amplink.testproject.view.tasklists

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.util.AppDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TaskListViewModel(private val context: Application): AndroidViewModel(context) {
    var tasks: MutableLiveData<MutableList<Task>> = MutableLiveData()

    fun setTasks() {
        val dao = AppDatabase.getInstance(context).taskDao()
        Observable.fromCallable { dao.getAll() }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    tasks.postValue(it)
                }
    }
}