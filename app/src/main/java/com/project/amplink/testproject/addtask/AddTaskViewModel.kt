package com.project.amplink.testproject.addtask

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.util.AppDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddTaskViewModel(var context:Application): AndroidViewModel(context) {
    var task: MutableLiveData<Task> = MutableLiveData()
    @SuppressLint("StaticFieldLeak")

    var isTitle: MutableLiveData<Boolean> = MutableLiveData()
    var isName: MutableLiveData<Boolean> = MutableLiveData()
    var isContent: MutableLiveData<Boolean> = MutableLiveData()

    init {
        task.postValue(Task(0, "", "", ""))

        isTitle.postValue(false)
        isName.postValue(false)
        isContent.postValue(false)
    }

    fun setIsTitle() {
        isTitle.postValue(task.value!!.title.isNotEmpty())
    }

    fun setIsName() {
        isName.postValue(task.value!!.name.isNotEmpty())
    }

    fun setIsContent() {
        isContent.postValue(task.value!!.content.isNotEmpty())
    }

    fun insertData() {
        val dao = AppDatabase.getInstance(context).taskDao()
        Observable.fromCallable {
            dao.insertTask(task.value!!)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}