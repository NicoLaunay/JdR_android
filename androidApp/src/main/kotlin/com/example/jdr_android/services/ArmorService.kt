package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import models.Armor

class ArmorService(private val db: JdrDatabase) {

    fun getAll(): List<Armor> =
        db.armorQueries
            .selectAll()
            .executeAsList()
            .map {
                Armor(
                    id = it.id.toInt(),
                    name = it.name,
                    defenseModifier = it.defense_modifier.toInt()
                )
            }  // SQLDelight → modèle

//    fun getById(id: Int): Armor? =
//        db.armorQueries
//            .selectById(id.toLong())
//            .executeAsOne()
//            .toModel()

    fun add(name: String, defenseModifier: Int) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.armorQueries.insert(
            name,
            defenseModifier.toLong())
    }

    fun delete(id: Int) =
        db.armorQueries.deleteById(id.toLong())

    fun toModel(armorLine: com.example.jdrandroid.db.Armor) =
        armorLine.let {
            Armor(
                id = it.id.toInt(),
                name = it.name,
                defenseModifier = it.defense_modifier.toInt()
            )
        }
}