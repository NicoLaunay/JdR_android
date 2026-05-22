package com.example.jdr_android.models

import com.example.jdr_android.enums.DamageType
import com.example.jdr_android.enums.DiceType

data class Damage(
    val id: Int,
    val damageDiceType: DiceType,
    val nbDice: Int,
    val modifier: Int,
    val type: DamageType
)
