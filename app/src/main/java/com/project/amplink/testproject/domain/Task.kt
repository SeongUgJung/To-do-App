package com.project.amplink.testproject.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * DTO?
 */
@Entity(tableName = "tasks")
data class Task @JvmOverloads constructor(
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "no") var no: Int,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "content") var content: String,
        @ColumnInfo(name = "name") var name: String)