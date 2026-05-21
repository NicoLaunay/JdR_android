package models

import enums.DiceType

data class Profile(
    val name: String,
    val lifeDice: DiceType,
    val paths: List<Path>
)
