package com.plandel.todoapp.di

import android.app.Application
import androidx.room.Room
import com.plandel.todoapp.data.TodoDao
import com.plandel.todoapp.data.TodoDatabase
import com.plandel.todoapp.repository.TodoRepository
import com.plandel.todoapp.ui.TodoViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TodoViewModel(get())
    }
}

val repositoryModule = module {
    single {
        TodoRepository(get())
    }
}

val databaseModule = module {

    fun provideDatabase(application: Application): TodoDatabase {
        return Room.databaseBuilder(application,TodoDatabase::class.java,"todo.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: TodoDatabase): TodoDao {
        return database.todoDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}