package com.project.amplink.testproject.domain.local

import com.project.amplink.testproject.domain.Task
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Database와 Query문으로 값을 가져오고 Rx를 이용하여 동기, 비동기를 나눔
 */
class TaskRepository private constructor(private val taskDao: TaskDao){
    fun getAll(onSuccess: (MutableList<Task>) -> Unit){
        getTasksOfRx({ taskDao.getAll() }, onSuccess)
    }
    fun getTask(taskNo: Int, onSuccess: (Task) -> Unit){
        getTasksOfRx({ taskDao.getTask(taskNo) }, onSuccess)
    }
    fun insertTask(task: Task, onSuccess: () -> Unit) {
        controllTaskOfRx({ taskDao.insertTask(task) }, onSuccess)
    }
    fun updateTask(task: Task, onSuccess: () -> Unit) {
        controllTaskOfRx({ taskDao.updateTask(task) }, onSuccess)
    }
    fun deleteTask(task: Task, onSuccess: () -> Unit) {
        controllTaskOfRx({ taskDao.deleteTask(task) }, onSuccess)
    }

    private fun controllTaskOfRx(onTask: () -> Unit, onSuccess: () -> Unit) {
        Observable.fromCallable { onTask() }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {}, {onSuccess()})
    }

    private fun <T: Any> getTasksOfRx(onTask: () -> T, onSuccess: (T ) -> Unit) {
        Observable.fromCallable { onTask() }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({onSuccess(it)}, {}, {})
    }

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(taskDao: TaskDao) =
                instance?: TaskRepository(taskDao).also { instance = it }
    }

}