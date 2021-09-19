package com.homanad.android.compose.data.repository

import com.homanad.android.compose.data.TestCoroutineRule
import com.homanad.android.compose.data.repository.datasource.TaskDataSource
import com.homanad.android.compose.domain.entity.TaskEntity
import com.homanad.android.compose.domain.repository.TaskRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class TaskRepositoryImplTest {

    private val dummyTaskEntity = TaskEntity(1, "Test")

    private val dummyTasks = listOf(
        TaskEntity(1, "TEST1"),
        TaskEntity(2, "TEST2"),
        TaskEntity(3, "TEST3"),
        TaskEntity(4, "TEST4"),
    )

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val taskDataSource = mock<TaskDataSource>()
    private lateinit var taskRepository: TaskRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        taskRepository = TaskRepositoryImpl(taskDataSource)
    }

    @Test
    fun shouldCreateTaskData() = testCoroutineRule.runBlockingTest {
        whenever(taskDataSource.createTask(dummyTaskEntity)).thenReturn(1L)

        assert(taskRepository.createTask(dummyTaskEntity) == 1L)
    }

    @Test
    fun shouldDeleteTaskData() = testCoroutineRule.runBlockingTest {
        whenever(taskDataSource.deleteTask(dummyTaskEntity)).thenReturn(1)

        assert(taskRepository.deleteTask(dummyTaskEntity) == 1)
    }

    @Test
    fun shouldUpdateTaskData() = testCoroutineRule.runBlockingTest {
        whenever(taskDataSource.updateTask(dummyTaskEntity)).thenReturn(1)

        assert(taskRepository.updateTask(dummyTaskEntity) == 1)
    }

    @Test
    fun shouldReturnTasks() = testCoroutineRule.runBlockingTest {
        whenever(taskDataSource.getTasks()).thenReturn(dummyTasks)

        assert(taskRepository.getTasks() == dummyTasks)
    }
}