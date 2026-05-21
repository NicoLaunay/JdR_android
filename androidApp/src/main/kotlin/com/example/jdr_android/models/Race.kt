package models

data class Race(
    val name: String,

    val strengthModifier: Int,
    val dexterityModifier: Int,
    val constitutionModifier: Int,
    val intelligenceModifier: Int,
    val wisdomModifier: Int,
    val charismaModifier: Int,

    val abilities: List<RacialAbility>
)
