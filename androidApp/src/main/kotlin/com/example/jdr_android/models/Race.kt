package com.example.jdr_android.models

data class Race(
    val id: Int,
    val name: String,

    val strengthModifier: Int,
    val dexterityModifier: Int,
    val constitutionModifier: Int,
    val intelligenceModifier: Int,
    val wisdomModifier: Int,
    val charismaModifier: Int,

    val abilities: List<RacialAbility>
)
