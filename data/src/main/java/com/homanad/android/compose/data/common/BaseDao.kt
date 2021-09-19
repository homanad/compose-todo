package com.homanad.android.compose.data.common

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(obj: T): Long

    @Insert
    suspend fun insert(vararg obj: T)

    @Insert
    suspend fun insert(objs: List<T>)

    @Delete
    suspend fun delete(vararg obj: T): Int

    @Update
    suspend fun update(vararg obj: T): Int
}