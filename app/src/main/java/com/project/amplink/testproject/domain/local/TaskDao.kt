package com.project.amplink.testproject.domain.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.project.amplink.testproject.domain.Task

/**
 *  데이터베이스에 접근하기 위한 Query문
 */
@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun getAll(): LiveData<MutableList<Task>>

    @Query("select * from tasks where `no` = :taskNo")
    fun getTask(taskNo: Int): Task

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)
}