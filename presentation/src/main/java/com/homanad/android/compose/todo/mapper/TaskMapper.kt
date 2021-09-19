package com.homanad.android.compose.todo.mapper

import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.todo.model.Task

fun TaskEntity.toTask() = Task(taskId, taskTitle)
fun Task.toTaskEntity() = TaskEntity(taskId, taskTitle)