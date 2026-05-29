package com.example.jdr_android.mappers

import com.example.jdr_android.enums.DiceType
import com.example.jdr_android.models.Armor
import com.example.jdr_android.models.Path
import com.example.jdr_android.models.Profile
import com.example.jdr_android.models.Weapon

fun com.example.jdrandroid.db.Profile.toModel(
    paths: List<Path>,
    starterWeapons: List<Weapon>,
    starterArmors: List<Armor>
) = Profile(
    id = id.toInt(),
    name = name,
    lifeDice = DiceType.valueOf(life_dice),
    paths = paths,
    starterWeapons = starterWeapons,
    starterArmors = starterArmors
)
