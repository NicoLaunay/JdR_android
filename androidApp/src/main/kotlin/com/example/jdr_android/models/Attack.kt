package models

import com.example.jdr_android.enums.Stat
import com.example.jdr_android.models.Damage
import enums.DiceType

data class Attack(
    val id: Int,
    val attackStat: Stat,
    val damageThrows: List<Damage>,
    val description: String
)
