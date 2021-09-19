package com.homanad.android.compose.data.repository.datasource

import com.homanad.android.compose.data.data.TaskData

interface TaskDataSource {
    suspend fun createTask(taskData: TaskData): Long
    suspend fun deleteTask(taskData: TaskData): Int
    suspend fun updateTask(taskData: TaskData): Int
    suspend fun getTasks(): List<TaskData>
}