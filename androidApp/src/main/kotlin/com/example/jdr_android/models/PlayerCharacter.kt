package models

import com.example.jdr_android.models.CharacterPath
import enums.EntitySize
import enums.EntityType

data class PlayerCharacter(
    val entity: Entity,

    val player: Player,
    val profile: Profile,

    val pcMax: Int,
    val pc: Int,
    val prMax: Int,
    val pr: Int,
    val pmMax: Int,
    val pm: Int,
)

