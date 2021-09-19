package com.homanad.android.compose.data.repository.datasource

import com.homanad.android.compose.data.db.dao.TaskDao
import com.homanad.android.compose.data.mapper.toTaskData
import com.homanad.android.compose.data.mapper.toTaskEntity
import com.homanad.android.compose.domain.entity.TaskEntity

class TaskDataSourceImpl(private val taskDao: TaskDao) : TaskDataSource {

    override suspend fun createTask(taskEntity: TaskEntity): Long =
        taskDao.insert(taskEntity.toTaskData())

    override suspend fun deleteTask(taskEntity: TaskEntity): Int =
        taskDao.delete(taskEntity.toTaskData())

    override suspend fun updateTask(taskEntity: TaskEntity): Int =
        taskDao.update(taskEntity.toTaskData())

    override suspend fun getTasks(): List<TaskEntity> = taskDao.getTasks().map { it.toTaskEntity() }
}