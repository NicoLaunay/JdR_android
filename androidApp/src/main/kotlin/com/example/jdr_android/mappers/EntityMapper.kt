package com.example.jdr_android.mappers

import com.example.jdr_android.enums.EntitySize
import com.example.jdr_android.enums.EntityType
import com.example.jdr_android.enums.Sex
import com.example.jdr_android.models.Armor
import com.example.jdr_android.models.EntityPath
import com.example.jdr_android.models.Entity
import com.example.jdr_android.models.Race
import com.example.jdr_android.models.Weapon

fun com.example.jdrandroid.db.Entity.toModel(
    race: Race,
    weapons: List<Weapon>,
    armors: List<Armor>,
    paths: List<EntityPath>
) = Entity(
    name = name,
    level = level,
    type = EntityType.valueOf(type),
    size = EntitySize.valueOf(size),
    age = age?.toInt(),
    weight = weight?.toFloat(),
    sex = Sex.valueOf(sex),
    race = race,
    copperCoinsNb = coins_copper.toInt(),
    silverCoinsNb = coins_silver.toInt(),
    goldCoinsNb = coins_gold.toInt(),
    platinumCoinsNb = coins_platinum.toInt(),
    items = items.toString().split(", "),
    strength = strength.toInt(),
    dexterity = dexterity.toInt(),
    constitution = constitution.toInt(),
    intelligence = intelligence.toInt(),
    wisdom = wisdom.toInt(),
    charisma = charisma.toInt(),
    pvMax = pv_max.toInt(),
    pv = pv.toInt(),
    weapons = weapons,
    armors = armors,
    paths = paths
)
