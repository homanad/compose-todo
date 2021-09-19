package com.homanad.android.compose.data.repository.datasource

import com.homanad.android.compose.data.data.TaskData
import com.homanad.android.compose.data.db.dao.TaskDao

class TaskDataSourceImpl(private val taskDao: TaskDao) : TaskDataSource {

    override suspend fun createTask(taskData: TaskData): Long = taskDao.insert(taskData)

    override suspend fun deleteTask(taskData: TaskData): Int = taskDao.delete(taskData)

    override suspend fun updateTask(taskData: TaskData): Int = taskDao.update(taskData)

    override suspend fun getTasks(): List<TaskData> = taskDao.getTasks()
}