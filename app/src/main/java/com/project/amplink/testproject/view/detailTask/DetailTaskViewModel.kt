package com.project.amplink.testproject.view.detailTask

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.util.AppDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailTaskViewModel(private val context: Application): AndroidViewModel(context) {
    private var task = MutableLiveData<Task>()

    private var isTitle = MutableLiveData<Boolean>()
    private var isContent = MutableLiveData<Boolean>()

    init {
        isTitle.postValue(false)
        isContent.postValue(false)
    }

    fun setTask(taskNo: Int) {
        val dao = AppDatabase.getInstance(context).taskDao()
        Observable.fromCallable { dao.getTask(taskNo) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ task.postValue(it) }, {}, {})
    }

    fun updateTask(onSuccess: () -> Unit) {
        val dao = AppDatabase.getInstance(context).taskDao()
        Observable.fromCallable { dao.updateTask(task.value!!) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }

    fun deleteTask(onSuccess: () -> Unit) {
        val dao = AppDatabase.getInstance(context).taskDao()
        Observable.fromCallable{ dao.deleteTask(task.value!!) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }

    fun getTask(): MutableLiveData<Task> {
        return task
    }

    fun getIsTitle(): MutableLiveData<Boolean> {
        return isTitle
    }

    fun getIsContent(): MutableLiveData<Boolean> {
        return isContent
    }

    fun setIsTitle() {
        isTitle.postValue(task.value!!.title.isNotEmpty())
    }

    fun setIsContent() {
        isContent.postValue(task.value!!.content.isNotEmpty())
    }
}