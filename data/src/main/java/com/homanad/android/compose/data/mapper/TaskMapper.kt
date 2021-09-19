package com.homanad.android.compose.data.mapper

import com.homanad.android.compose.data.data.TaskData
import com.homanad.android.compose.domain.entity.TaskEntity

fun TaskEntity.toTaskData() = TaskData(taskId, taskTitle)
fun TaskData.toTaskEntity() = TaskEntity(taskId, taskTitle)