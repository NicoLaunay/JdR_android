package com.example.jdr_android.mappers

import com.example.jdr_android.enums.Stat
import com.example.jdr_android.models.Attack
import com.example.jdr_android.models.Damage

fun com.example.jdrandroid.db.Attack.toModel(damages: List<Damage>) = Attack(
    id = id.toInt(),
    attackStat = Stat.valueOf(attack_stat),
    damageThrows = damages,
    description = description
)
