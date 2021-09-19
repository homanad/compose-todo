package com.homanad.android.compose.data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskData(
    @PrimaryKey
    val taskId: Long,
    val taskTitle: String
)