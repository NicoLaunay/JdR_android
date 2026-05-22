package com.example.jdr_android.mappers

import com.example.jdr_android.models.Race
import com.example.jdr_android.models.RacialAbility
import com.example.jdr_android.services.RacialAbilityService

fun com.example.jdrandroid.db.Race.toModel(abilities: List<RacialAbility>) = Race(
    id = id.toInt(),
    name = name,
    strengthModifier = 0,
    dexterityModifier = 0,
    constitutionModifier = 0,
    intelligenceModifier = 0,
    wisdomModifier = 0,
    charismaModifier = 0,
    abilities = abilities)