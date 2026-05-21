package models

import enums.DiceType

data class Attack(
    val attackModifier: Int,
    val damageDiceType: DiceType,
    val damageDiceNb: Int,
    val damageModifier: Int
)
