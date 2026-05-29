package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toEntityPath
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.EntityPath
import com.example.jdr_android.models.Path

class EntityPathService(private val db: JdrDatabase) {

    private val skillService = SkillService(db)

//    fun getAll(): List<Path> =
//        db.pathQueries
//            .selectAll()
//            .executeAsList()
//            .map { it.toModel(skillService.getAllByPathId(it.id.toInt())) }

    fun getAllByEntityId(id: Int): List<EntityPath> =
        db.entityKnowsPathQueries
            .selectPathsByEntity(id.toLong())
            .executeAsList()
            .map {
                it.toEntityPath(id, skillService.getAllByPathId(it.id.toInt()))
            }

    fun teachPathToEntity(entityId: Int, pathId: Int, pathLevel: Int) {
        val pathMaxLevel = db.skillQueries.selectAllByPathId(pathId.toLong())
            .executeAsList()
            .count()
        require(pathLevel > 0) { "Le niveau dans la voie doit être au moins de 1" }
        require(pathLevel <= pathMaxLevel) { "Le niveau dans cette voie ne peut être supérieur à $pathMaxLevel" }
        db.entityKnowsPathQueries.teachPathToEntity(entityId.toLong(), pathId.toLong(), pathLevel.toLong())
    }

    fun deletePathFromEntity(entityId: Int, pathId: Int) =
        db.entityKnowsPathQueries.deletePathFromEntity(entityId.toLong(), pathId.toLong())
}
