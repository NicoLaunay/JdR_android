package com.example.jdr_android.models

data class Weapon(
    val id: Int,
    val name: String,
    val attacks: List<Attack>
)
