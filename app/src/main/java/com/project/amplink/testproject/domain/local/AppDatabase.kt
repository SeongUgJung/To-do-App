package com.project.amplink.testproject.domain.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.project.amplink.testproject.domain.Task


@Database(entities = [(Task::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "Tasks.db")
                        .build()
            }
            return INSTANCE!!
        }
    }

    abstract fun taskDao(): TaskDao
}