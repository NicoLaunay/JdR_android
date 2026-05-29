package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Skill

class SkillService(private val db: JdrDatabase) {

    fun getAll(): List<Skill> =
        db.skillQueries
            .selectAll()
            .executeAsList()
            .map {
                it.toModel()
            }  // SQLDelight → modèle

    fun getAllByPathId(pathId: Int): List<Skill> =
        db.skillQueries
            .selectAllByPathId(pathId.toLong())
            .executeAsList()
            .map {
                it.toModel()
            }

    fun getById(id: Int): Skill? =
        db.skillQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel()

    fun add(skill: Skill) {
        require(skill.name.isNotBlank()) { "Le nom ne peut pas être vide" }
        require(skill.description.isNotBlank()) { "La description ne peut pas être vide" }
        db.skillQueries.insert(
            skill.name,
            skill.isLimited,
            skill.isSpell,
            skill.level.toLong(),
            skill.description
        )
    }

//    fun update(id: Int, name: String, defenseModifier: Int) {
//        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
//        db.skillQueries.updateById(
//            name,
//            defenseModifier.toLong(),
//            id.toLong())
//    }

    fun delete(id: Int) =
        db.skillQueries.deleteById(id.toLong())
}