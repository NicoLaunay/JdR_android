package com.example.jdr_android.mappers

import com.example.jdr_android.models.EntityPath
import com.example.jdr_android.models.Path
import com.example.jdr_android.models.Skill
import com.example.jdrandroid.db.SelectPathsByEntity

//fun Entity_Knows_Path.toPath(path: Path) = EntityPath(
//    idCharacter = id_entity.toInt(),
//    path = path,
//    levelReached = level_reached.toInt()

fun SelectPathsByEntity.toEntityPath(entityId: Int, skills: List<Skill>) = EntityPath(
    idCharacter = entityId,
    path = Path(
        id = id.toInt(),
        name = name,
        skills = skills
    ),
    levelReached = level_reached.toInt()
)