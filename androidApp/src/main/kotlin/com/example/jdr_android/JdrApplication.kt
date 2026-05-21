package com.example.jdr_android

import android.app.Application
import com.example.jdr_android.db.JdrDatabase

class JdrApplication : Application() {

    lateinit var database: JdrDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = JdrDatabase(
            DatabaseDriverFactory(this).create()
        )
    }
}