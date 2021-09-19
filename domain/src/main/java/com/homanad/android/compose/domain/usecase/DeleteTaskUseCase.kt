package com.homanad.android.compose.domain.usecase

import com.homanad.android.compose.domain.common.UseCaseWithParam
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository

class DeleteTaskUseCase(
    private val taskRepository: TaskRepository
) : UseCaseWithParam<TaskEntity, Int>() {

    override suspend fun create(param: TaskEntity): Int = taskRepository.deleteTask(param)
}