package com.project.amplink.testproject.domain.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.project.amplink.testproject.domain.Task

/**
 *  Android Database Of Room
 *
 *  안드로이드 데이터베이스에 접근하는 database instance를 singleton으로 생성
 *
 */
@Database(entities = [(Task::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) =
                INSTANCE?:Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Tasks.db").build()
                        .also { INSTANCE = it }
    }

    abstract fun taskDao(): TaskDao
}