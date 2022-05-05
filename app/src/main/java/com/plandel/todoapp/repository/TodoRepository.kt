package com.plandel.todoapp.repository

import com.plandel.todoapp.data.TodoDao
import com.plandel.todoapp.model.Todo

class TodoRepository(private val todoDao: TodoDao) {

    fun addTodo(todo:Todo) = todoDao.addTodo(todo)

    fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)

    fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)

    fun getAllTodos() = todoDao.getAllTodos()
}