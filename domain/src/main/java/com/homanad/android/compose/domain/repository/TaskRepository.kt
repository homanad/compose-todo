package com.homanad.android.compose.domain.repository

import com.homanad.android.compose.domain.entity.TaskEntity

interface TaskRepository {
    suspend fun createTask(taskEntity: TaskEntity): Long
    suspend fun deleteTask(taskEntity: TaskEntity): Int
    suspend fun updateTask(taskEntity: TaskEntity): Int
    suspend fun getTasks(): List<TaskEntity>
}