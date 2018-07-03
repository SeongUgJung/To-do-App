package com.project.amplink.testproject.domain.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.project.amplink.testproject.domain.Task

@Dao
interface TaskDao {
    @Query("select * from tasks")
    fun getAll(): List<Task>

    @Query("select * from tasks where `no` = :taskNo")
    fun getTask(taskNo: Int): Task

    @Insert
    fun insertTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}