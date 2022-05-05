package com.plandel.todoapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.plandel.todoapp.model.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY id ASC")
    fun getAllTodos(): LiveData<List<Todo>>
}