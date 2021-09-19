package com.homanad.android.compose.todo.ui.pages.state

import com.homanad.android.compose.todo.model.Task

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Error(val message: String) : MainState()
    data class TasksReturned(val tasks: List<Task>) : MainState()
    data class TaskCreated(val id: Long) : MainState()
    data class TaskDeleted(val row: Int) : MainState()
    data class TaskUpdated(val row: Int) : MainState()
}