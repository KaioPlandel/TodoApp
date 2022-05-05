package com.plandel.todoapp.ui

import androidx.lifecycle.ViewModel
import com.plandel.todoapp.model.Todo
import com.plandel.todoapp.repository.TodoRepository

class TodoViewModel (private val repository: TodoRepository) : ViewModel() {
    val todoData = repository.getAllTodos()

    fun addTodo(todo: Todo): Boolean{
        repository.addTodo(todo)
        return true
    }

    fun deleteTodo(todo: Todo): Boolean{
        repository.deleteTodo(todo)
        return true
    }

    fun updateTodo(todo: Todo): Boolean{
        repository.updateTodo(todo)
        return true
    }
}