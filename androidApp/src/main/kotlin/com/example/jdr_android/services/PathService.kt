package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Path

class PathService(private val db: JdrDatabase) {

    private val skillService = SkillService(db)

    fun getAll(): List<Path> =
        db.pathQueries
            .selectAll()
            .executeAsList()
            .map { it.toModel(skillService.getAllByPathId(it.id.toInt())) }

    fun getById(id: Int): Path =
        db.pathQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel(skillService.getAllByPathId(id))

    fun getAllByProfileId(profileId: Int): List<Path> =
        db.profileContainsPathQueries
            .selectPathsByProfile(profileId.toLong())
            .executeAsList()
            .map { it.toModel(skillService.getAllByPathId(it.id.toInt())) }

    fun add(profileId: Int, name: String, description: String?) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.pathQueries.insert(profileId.toLong(), name, description)
    }

    fun delete(id: Int) =
        db.pathQueries.deleteById(id.toLong())
}
