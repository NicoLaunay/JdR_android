package com.example.jdr_android

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.jdr_android.db.JdrDatabase

class DatabaseDriverFactory(private val context: Context) {
    fun create() = AndroidSqliteDriver(
        schema = JdrDatabase.Companion.Schema,
        context = context,
        name = "jdr.db"
    )
}