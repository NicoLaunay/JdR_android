package com.example.jdr_android.mappers

import com.example.jdr_android.models.RacialAbility

fun com.example.jdrandroid.db.RacialAbility.toModel() = RacialAbility(
    id = id.toInt(),
    name = name,
    description = description
)