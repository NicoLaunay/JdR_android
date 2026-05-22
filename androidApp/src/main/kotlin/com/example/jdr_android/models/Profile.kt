package models

import enums.DiceType

data class Profile(
    val id: Int,
    val name: String,
    val lifeDice: DiceType,
    val paths: List<Path>
)
