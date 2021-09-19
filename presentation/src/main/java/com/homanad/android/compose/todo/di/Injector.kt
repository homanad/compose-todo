package com.homanad.android.compose.todo.di

import android.content.Context
import com.homanad.android.compose.data.db.TaskDatabase
import com.homanad.android.compose.data.repository.TaskRepositoryImpl
import com.homanad.android.compose.data.repository.datasource.TaskDataSourceImpl
import com.homanad.android.compose.domain.usecase.CreateTaskUseCase
import com.homanad.android.compose.domain.usecase.DeleteTaskUseCase
import com.homanad.android.compose.domain.usecase.GetTasksUseCase
import com.homanad.android.compose.domain.usecase.UpdateTaskUseCase

object Injector {

    @Synchronized
    fun provideTaskDatabase(context: Context) = TaskDatabase.getInstance(context)

    @Synchronized
    fun provideTaskDataSource(context: Context) =
        TaskDataSourceImpl(provideTaskDatabase(context).taskDao)

    @Synchronized
    fun provideTaskRepository(context: Context) = TaskRepositoryImpl(provideTaskDataSource(context))

    @Synchronized
    fun getCreateTaskUseCase(context: Context) = CreateTaskUseCase(provideTaskRepository(context))

    @Synchronized
    fun getDeleteTaskUseCase(context: Context) = DeleteTaskUseCase(provideTaskRepository(context))

    @Synchronized
    fun getUpdateTaskUseCase(context: Context) = UpdateTaskUseCase(provideTaskRepository(context))

    @Synchronized
    fun getGetTasksUseCase(context: Context) = GetTasksUseCase(provideTaskRepository(context))
}