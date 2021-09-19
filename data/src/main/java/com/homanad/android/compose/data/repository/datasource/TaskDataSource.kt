package com.homanad.android.compose.data.repository.datasource

import com.homanad.android.compose.domain.entity.TaskEntity

interface TaskDataSource {
    suspend fun createTask(taskEntity: TaskEntity): Long
    suspend fun deleteTask(taskEntity: TaskEntity): Int
    suspend fun updateTask(taskEntity: TaskEntity): Int
    suspend fun getTasks(): List<TaskEntity>
}