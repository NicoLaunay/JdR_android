package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Armor

class ArmorService(private val db: JdrDatabase) {

    fun getAll(): List<Armor> =
        db.armorQueries
            .selectAll()
            .executeAsList()
            .map {
                it.toModel()
            }  // SQLDelight → modèle

    fun getStartersByProfileId(profileId: Int): List<Armor> =
        db.armorQueries
            .selectStartersByProfileId(profileId.toLong())
            .executeAsList()
            .map {
                it.toModel()
            }

    fun getAllByOwnerId(ownerId: Int): List<Armor> =
        db.armorQueries
            .selectAllByOwnerId(ownerId.toLong())
            .executeAsList()
            .map {
                it.toModel()
            }

    fun getById(id: Int): Armor? =
        db.armorQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel()

    fun add(name: String, defenseModifier: Int) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.armorQueries.insert(
            name,
            defenseModifier.toLong())
    }

    fun update(id: Int, name: String, defenseModifier: Int) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.armorQueries.updateById(
            name,
            defenseModifier.toLong(),
            id.toLong())
    }

    fun delete(id: Int) =
        db.armorQueries.deleteById(id.toLong())
}