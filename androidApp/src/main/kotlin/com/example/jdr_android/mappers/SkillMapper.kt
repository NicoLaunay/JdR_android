package com.example.jdr_android.mappers

import com.example.jdr_android.models.Skill
import kotlin.String

fun com.example.jdrandroid.db.Skill.toModel() = Skill(
    id = id.toInt(),
    name = name,
    level = level.toInt(),
    description = description,
    isLimited = isLimited,
    isSpell = isSpell,
)