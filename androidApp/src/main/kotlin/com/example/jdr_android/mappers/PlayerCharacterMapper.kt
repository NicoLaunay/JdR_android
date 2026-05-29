package com.example.jdr_android.mappers

import com.example.jdr_android.models.Entity
import com.example.jdr_android.models.Inventory
import com.example.jdr_android.models.Player
import com.example.jdr_android.models.PlayerCharacter
import com.example.jdr_android.models.Profile

fun com.example.jdrandroid.db.PlayableCharacter.toModel(
    entity: Entity,
    player: Player,
    profile: Profile
) = PlayerCharacter(
    entity = entity,
    player = player,
    profile = profile,
    pcMax = pc_max?.toInt() ?: 0,
    pc = pc?.toInt() ?: 0,
    prMax = pr_max?.toInt() ?: 0,
    pr = pr?.toInt() ?: 0,
    pmMax = pm_max?.toInt() ?: 0,
    pm = pm?.toInt() ?: 0,
)
