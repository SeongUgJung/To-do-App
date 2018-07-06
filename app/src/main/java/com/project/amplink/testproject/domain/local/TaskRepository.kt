package com.project.amplink.testproject.domain.local

import com.project.amplink.testproject.domain.Task
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Database와 Query문으로 값을 가져오고 Rx를 이용하여 동기, 비동기를 나눔
 */
class TaskRepository private constructor(private val taskDao: TaskDao) {
    fun getAll() = taskDao.getAll()
    fun getAllRx() = taskDao.getAllRx()

    fun getTask(taskNo: Int) = Observable.fromCallable { taskDao.getTask(taskNo) }.subscribeOn(Schedulers.io()).blockingFirst()!!

    fun insertTask(task: Task) {
        Completable.fromCallable { taskDao.insertTask(task) }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun updateTask(task: Task) {
        Completable.fromCallable { taskDao.updateTask(task) }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun deleteTask(task: Task) {
        Completable.fromCallable { taskDao.deleteTask(task) }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(taskDao: TaskDao) =
            instance ?: TaskRepository(taskDao).also { instance = it }
    }

}