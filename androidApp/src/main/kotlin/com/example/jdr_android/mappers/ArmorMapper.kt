package com.example.jdr_android.mappers

import com.example.jdr_android.models.Armor

fun com.example.jdrandroid.db.Armor.toModel() = Armor(
    id = id.toInt(),
    name = name,
    defenseModifier = defense_modifier.toInt()
)