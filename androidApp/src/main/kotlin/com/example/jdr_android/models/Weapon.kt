package models

import enums.DiceType

data class Weapon(
    val name: String,
    val attacks: List<Attack>
)
