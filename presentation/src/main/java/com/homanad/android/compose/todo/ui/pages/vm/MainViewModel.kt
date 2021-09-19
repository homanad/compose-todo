package com.homanad.android.compose.todo.ui.pages.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homanad.android.compose.domain.usecase.CreateTaskUseCase
import com.homanad.android.compose.domain.usecase.DeleteTaskUseCase
import com.homanad.android.compose.domain.usecase.GetTasksUseCase
import com.homanad.android.compose.domain.usecase.UpdateTaskUseCase
import com.homanad.android.compose.todo.mapper.toTask
import com.homanad.android.compose.todo.mapper.toTaskEntity
import com.homanad.android.compose.todo.model.Task
import com.homanad.android.compose.todo.ui.pages.intent.MainIntent
import com.homanad.android.compose.todo.ui.pages.state.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val createTaskUseCase: CreateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state: StateFlow<MainState> = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch(Dispatchers.IO) {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.GetTasksIntent -> getTasks()
                    is MainIntent.CreateTaskIntent -> createTask(it.task)
                    is MainIntent.DeleteTaskIntent -> deleteTask(it.task)
                    is MainIntent.UpdateTaskIntent -> updateTask(it.task)
                }
            }
        }
    }

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.TasksReturned(getTasksUseCase().map { it.toTask() })
            } catch (e: Exception) {
                MainState.Error("Can't get tasks")
            }
        }
    }

    private fun createTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.TaskCreated(createTaskUseCase(task.toTaskEntity()))
            } catch (e: Exception) {
                MainState.Error("Can't create")
            }
        }
    }

    private fun deleteTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.TaskDeleted(deleteTaskUseCase(task.toTaskEntity()))
            } catch (e: Exception) {
                MainState.Error("Can't delete")
            }
        }
    }

    private fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.TaskDeleted(updateTaskUseCase(task.toTaskEntity()))
            } catch (e: Exception) {
                MainState.Error("Can't update")
            }
        }
    }
}