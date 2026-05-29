package com.example.jdr_android.mappers

import com.example.jdr_android.enums.DamageType
import com.example.jdr_android.enums.DiceType
import com.example.jdr_android.models.Damage

fun com.example.jdrandroid.db.Damage.toModel() = Damage(
    id = id.toInt(),
    damageDiceType = DiceType.valueOf(damage_dice),
    nbDice = nb_damage_dice.toInt(),
    modifier = damage_modifier.toInt(),
    type = DamageType.valueOf(damage_type)
)
