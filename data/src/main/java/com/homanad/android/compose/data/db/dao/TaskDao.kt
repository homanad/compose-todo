package com.homanad.android.compose.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.homanad.android.compose.data.common.BaseDao
import com.homanad.android.compose.data.data.TaskData

@Dao
abstract class TaskDao : BaseDao<TaskData> {

    @Query("SELECT * FROM TaskData")
    abstract suspend fun getTasks(): List<TaskData>
}