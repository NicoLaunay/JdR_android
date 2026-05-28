package com.example.jdr_android.models

data class Skill(
    val id: Int,
    val name: String,
    val level: Int,
    val description: String,
    val isLimited: Boolean,
    val isSpell: Boolean,
)
