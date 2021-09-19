package com.homanad.android.compose.domain.usecase

import com.homanad.android.compose.domain.common.UseCaseWithParam
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository

class CreateTaskUseCase(
    private val taskRepository: TaskRepository
) : UseCaseWithParam<TaskEntity, Long>() {

    override suspend fun create(param: TaskEntity): Long = taskRepository.createTask(param)
}