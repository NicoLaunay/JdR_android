package com.example.jdr_android.mappers

import com.example.jdr_android.models.Path
import com.example.jdr_android.models.Skill

fun com.example.jdrandroid.db.Path.toModel(skills: List<Skill>) = Path(
    id = id.toInt(),
    name = name,
    skills = skills
)
