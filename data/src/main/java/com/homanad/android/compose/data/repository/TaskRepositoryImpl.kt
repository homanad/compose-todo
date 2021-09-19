package com.homanad.android.compose.data.repository

import com.homanad.android.compose.data.mapper.toTaskData
import com.homanad.android.compose.data.mapper.toTaskEntity
import com.homanad.android.compose.data.repository.datasource.TaskDataSource
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDataSource: TaskDataSource) : TaskRepository {

    override suspend fun createTask(taskEntity: TaskEntity): Long {
        return taskDataSource.createTask(taskEntity.toTaskData())
    }

    override suspend fun deleteTask(taskEntity: TaskEntity): Int {
        return taskDataSource.deleteTask(taskEntity.toTaskData())
    }

    override suspend fun updateTask(taskEntity: TaskEntity): Int {
        return taskDataSource.updateTask(taskEntity.toTaskData())
    }

    override suspend fun getTasks(): List<TaskEntity> {
        return taskDataSource.getTasks().map { it.toTaskEntity() }
    }
}