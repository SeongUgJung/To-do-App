package com.project.amplink.testproject.domain.local

import android.arch.lifecycle.LiveData
import com.project.amplink.testproject.domain.Task
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Database와 Query문으로 값을 가져오고 Rx를 이용하여 동기, 비동기를 나눔
 */
class TaskRepository private constructor(private val taskDao: TaskDao){
    fun getAll(): LiveData<MutableList<Task>> = taskDao.getAll()

    fun getTask(taskNo: Int) = Observable.fromCallable { taskDao.getTask(taskNo) }.subscribeOn(Schedulers.io()).blockingFirst()!!

    fun insertTask(task: Task) { Observable.fromCallable { taskDao.insertTask(task) }.subscribeOn(Schedulers.io()) }

    fun updateTask(task: Task) { Observable.fromCallable { taskDao.updateTask(task) }.subscribeOn(Schedulers.io()) }

    fun deleteTask(task: Task) { Observable.fromCallable { taskDao.deleteTask(task) }.subscribeOn(Schedulers.io()) }

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(taskDao: TaskDao) =
                instance?: TaskRepository(taskDao).also { instance = it }
    }

}