package com.project.amplink.testproject.domain.local

import android.arch.persistence.room.*
import com.project.amplink.testproject.domain.Task

@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun getAll(): MutableList<Task>

    @Query("select * from tasks where `no` = :taskNo")
    fun getTask(taskNo: Int): Task

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Update
    fun updateTask(task: Task)
}