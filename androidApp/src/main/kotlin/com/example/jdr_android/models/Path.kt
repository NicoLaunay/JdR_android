package com.example.jdr_android.models

data class Path(
    val id: Int,
    val name: String,
    val maxLevel: Int,
    val skills: List<Skill>
)
