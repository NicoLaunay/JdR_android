package com.example.jdr_android.mappers

import com.example.jdr_android.models.Player

fun com.example.jdrandroid.db.Player.toModel() = Player(
    id = id.toInt(),
    name = name,
)