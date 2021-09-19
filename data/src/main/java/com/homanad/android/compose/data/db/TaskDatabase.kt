package com.homanad.android.compose.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.homanad.android.compose.data.data.TaskData
import com.homanad.android.compose.data.db.dao.TaskDao

@Database(entities = [TaskData::class], exportSchema = true, version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDao: TaskDao

    companion object {

        @Volatile
        private var INSTANCE: TaskDatabase? = null
        fun getInstance(context: Context): TaskDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        TaskDatabase::class.java.name
                    ).build()
                }
                return instance
            }
        }
    }
}