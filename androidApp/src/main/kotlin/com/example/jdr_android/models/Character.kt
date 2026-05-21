package models

import com.example.jdr_android.models.CharacterPath
import enums.EntitySize
import enums.EntityType

data class Character (
    val level: Float,
    val age: Int,
    val weight: Float,
    val race: Race,
    val inventory: Inventory,

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
