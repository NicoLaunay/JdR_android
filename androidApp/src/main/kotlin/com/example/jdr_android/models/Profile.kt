package com.example.jdr_android.models

import com.example.jdr_android.enums.DiceType

data class Profile(
    val id: Int,
    val name: String,
    val lifeDice: DiceType,
    val paths: List<Path>,
    val starterWeapons: List<Weapon>,
    val starterArmors: List<Armor>
)
