package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.RacialAbility

class RacialAbilityService(private val db: JdrDatabase) {

    fun getAll(): List<RacialAbility> =
        db.racialAbilityQueries
            .selectAll()
            .executeAsList()
            .map {
                it.toModel()
            }  // SQLDelight → modèle

    fun getAllByRaceId(id: Int): List<RacialAbility> =
        db.racePossessesAbilityQueries
            .selectAbilitiesByRace(id.toLong())
            .executeAsList()
            .map {
                it.toModel()
            }  // SQLDelight → modèle

    fun getById(id: Int): RacialAbility =
        db.racialAbilityQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel()

    fun add(name: String, description: String) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.racialAbilityQueries.insert(
            name,
            description)
    }

    fun update(id: Int, name: String, description: String) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        require(description.isNotBlank()) { "La description ne peut pas être vide" }
        db.racialAbilityQueries.updateById(
            name,
            description,
            id.toLong())
    }

    fun delete(id: Int) =
        db.racialAbilityQueries.deleteById(id.toLong())
}