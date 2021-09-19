package com.homanad.android.compose.domain.repository

import com.homanad.android.compose.domain.entity.TaskEntity

interface TaskRepository {
    fun createTask(taskEntity: TaskEntity): Long
    fun deleteTask(taskEntity: TaskEntity): Int
    fun updateTask(taskEntity: TaskEntity): Int
    fun getTasks(): List<TaskEntity>
}