package com.example.jdr_android.models

import com.example.jdr_android.enums.Stat

data class Attack(
    val id: Int,
    val attackStat: Stat,
    val damageThrows: List<Damage>,
    val description: String
)
