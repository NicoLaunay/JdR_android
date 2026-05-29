package com.example.jdr_android.mappers

import com.example.jdr_android.models.Attack
import com.example.jdr_android.models.Weapon

fun com.example.jdrandroid.db.Weapon.toModel(attacks: List<Attack>) = Weapon(
    id = id.toInt(),
    name = name,
    attacks = attacks
)
