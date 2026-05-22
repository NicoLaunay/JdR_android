package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Race
import com.example.jdr_android.models.RacialAbility

class RaceService(private val db: JdrDatabase) {

    val abilityService = RacialAbilityService(db)

    fun getAll(): List<Race> =
        db.raceQueries
            .selectAll()
            .executeAsList()
            .map {
                it.toModel(
                    abilityService
                    .getAllByRaceId(it.id.toInt())
                )
            }

    fun getById(id: Int): Race =
        db.raceQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel(
                abilityService
                    .getAllByRaceId(id)
            )

    fun add(name: String, str: Int, dex: Int, con: Int, int: Int, wis: Int, cha: Int, abilities: List<RacialAbility>) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.raceQueries.insert(
            name,
            str.toLong(),
            dex.toLong(),
            con.toLong(),
            int.toLong(),
            wis.toLong(),
            cha.toLong()
        )
        val raceId = db.raceQueries
            .lastInsertRowId()
            .executeAsOne()

        for (ability in abilities) {
            db.racePossessesAbilityQueries
                .linkRaceToAbility(raceId, ability.id.toLong())
        }
    }

//    fun update(id: Int, name: String, description: String) {
//        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
//        require(description.isNotBlank()) { "La description ne peut pas être vide" }
//        db.raceQueries.updateById(
//            name,
//            id.toLong())
//    }

    fun delete(id: Int) =
        db.raceQueries.deleteById(id.toLong())
}