package com.plandel.todoapp

import android.app.Application
import com.plandel.todoapp.di.databaseModule
import com.plandel.todoapp.di.repositoryModule
import com.plandel.todoapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@TodoApplication)
            modules(listOf(viewModelModule, repositoryModule, databaseModule))
        }
    }
}