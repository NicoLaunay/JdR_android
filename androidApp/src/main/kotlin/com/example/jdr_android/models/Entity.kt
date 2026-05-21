package models

import com.example.jdr_android.models.CharacterPath
import enums.EntitySize
import enums.EntityType

abstract class Entity(
    open var name: String,
    open var type: EntityType,
    open var size: EntitySize,

    open var strength: Int,
    open var dexterity: Int,
    open var constitution: Int,
    open var intelligence: Int,
    open var wisdom: Int,
    open var charisma: Int,

    open var pvMax: Int,
    open var pv: Int,

    open var weapons: List<Weapon>,
    open var armors: List<Armor>,

    open var paths: List<CharacterPath>
)
