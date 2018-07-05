package com.project.amplink.testproject.domain.local

import com.project.amplink.testproject.domain.Task
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TaskRepository private constructor(private val taskDao: TaskDao){
    fun getAll(onSuccess: (MutableList<Task>) -> Unit){
        Observable.fromCallable { taskDao.getAll() }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { onSuccess(it) }
    }
    fun getTask(taskNo: Int, onSuccess: (Task) -> Unit){
        Observable.fromCallable { taskDao.getTask(taskNo) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe { onSuccess(it) }
    }
    fun insertTask(task: Task, onSuccess: () -> Unit) {
        Observable.fromCallable { taskDao.insertTask(task) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }
    fun updateTask(task: Task, onSuccess: () -> Unit) {
        Observable.fromCallable { taskDao.updateTask(task) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }
    fun deleteTask(task: Task, onSuccess: () -> Unit) {
        Observable.fromCallable { taskDao.deleteTask(task) }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(taskDao: TaskDao) =
                instance?: TaskRepository(taskDao).also { instance = it }
    }

}