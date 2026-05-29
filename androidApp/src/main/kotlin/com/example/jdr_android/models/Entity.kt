package com.example.jdr_android.models

import com.example.jdr_android.enums.EntitySize
import com.example.jdr_android.enums.EntityType
import com.example.jdr_android.enums.Sex

data class Entity(
    val name: String,
    val level: Double,
    val type: EntityType,
    val size: EntitySize,

    val age: Int?,
    val weight: Float?,
    val sex: Sex,
    val race: Race,

    var copperCoinsNb: Int,
    var silverCoinsNb: Int,
    var goldCoinsNb: Int,
    var platinumCoinsNb: Int,
    var items: List<String>,

    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,

    val pvMax: Int,
    val pv: Int,

    val weapons: List<Weapon>,
    val armors: List<Armor>,

    val paths: List<EntityPath>
)
