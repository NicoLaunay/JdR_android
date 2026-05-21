package models

data class Path(
    val name: String,
    val maxLevel: Int,
    val skills: List<Skill>
)
