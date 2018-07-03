package com.project.amplink.testproject.util

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.project.amplink.testproject.domain.Task
import com.project.amplink.testproject.domain.local.TaskDao


@Database(entities = [(Task::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {

        private var INSTANCE: AppDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "Tasks.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }

    abstract fun taskDao(): TaskDao
}