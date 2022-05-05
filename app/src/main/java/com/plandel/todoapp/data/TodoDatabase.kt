package com.plandel.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plandel.todoapp.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase(){
    abstract val todoDao: TodoDao
}