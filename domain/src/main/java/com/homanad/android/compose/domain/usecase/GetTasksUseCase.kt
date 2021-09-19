package com.homanad.android.compose.domain.usecase

import com.homanad.android.compose.domain.common.UseCase
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository

class GetTasksUseCase(
    private val taskRepository: TaskRepository
) : UseCase<List<TaskEntity>>() {

    override suspend fun create(): List<TaskEntity> = taskRepository.getTasks()
}