package models

import com.example.jdr_android.models.CharacterPath
import enums.EntitySize
import enums.EntityType

data class PlayerCharacter(
    val player: Player,
    val level: Int,
    val age: Int,
    val weight: Float,
    val race: Race,
    val profile: Profile,

    val inventory: Inventory,

    val pcMax: Int,
    val pc: Int,
    val prMax: Int,
    val pr: Int,
    val pmMax: Int,
    val pm: Int,

    override var name: String,
    override var type: EntityType,
    override var size: EntitySize,

    override var strength: Int,
    override var dexterity: Int,
    override var constitution: Int,
    override var intelligence: Int,
    override var wisdom: Int,
    override var charisma: Int,

    override var pvMax: Int,
    override var pv: Int,

    override var weapons: List<Weapon>,
    override var armors: List<Armor>,

    override var paths: List<CharacterPath>
): Entity(
    name,
    type,
    size,
    strength,
    dexterity,
    constitution,
    intelligence,
    wisdom,
    charisma,
    pvMax,
    pv,
    weapons,
    armors,
    paths
)

