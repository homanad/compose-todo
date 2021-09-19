package com.homanad.android.compose.todo.ui.pages.intent

import com.homanad.android.compose.todo.model.Task

sealed class MainIntent {
    object GetTasksIntent : MainIntent()
    data class CreateTaskIntent(val task: Task) : MainIntent()
    data class DeleteTaskIntent(val task: Task) : MainIntent()
    data class UpdateTaskIntent(val task: Task) : MainIntent()
}