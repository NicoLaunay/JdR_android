package models

import enums.DiceType

data class Weapon(
    val id: Int,
    val name: String,
    val attacks: List<Attack>
)
