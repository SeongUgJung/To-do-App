package com.project.amplink.testproject.domain.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.project.amplink.testproject.domain.Task
import io.reactivex.Flowable

/**
 *  데이터베이스에 접근하기 위한 Query문
 */
@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun getAll(): LiveData<MutableList<Task>>

    @Query("select * from tasks")
    fun getAllRx(): Flowable<MutableList<Task>>

    @Query("select * from tasks where `no` = :taskNo")
    fun getTask(taskNo: Int): Task

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)
}