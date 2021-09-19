package com.homanad.android.compose.data.repository

import com.homanad.android.compose.data.repository.datasource.TaskDataSource
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource) : TaskRepository {

    override suspend fun createTask(taskEntity: TaskEntity): Long =
        taskDataSource.createTask(taskEntity)

    override suspend fun deleteTask(taskEntity: TaskEntity): Int =
        taskDataSource.deleteTask(taskEntity)

    override suspend fun updateTask(taskEntity: TaskEntity): Int =
        taskDataSource.updateTask(taskEntity)

    override suspend fun getTasks(): List<TaskEntity> = taskDataSource.getTasks()
}