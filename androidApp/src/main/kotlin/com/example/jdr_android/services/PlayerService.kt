package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.models.Player

class PlayerService(private val db: JdrDatabase) {

    fun getAll(): List<Player> =
        db.playerQueries
            .selectAll()
            .executeAsList()
            .map {
                Player(
                id = it.id.toInt(),
                name = it.name)
            }  // SQLDelight → modèle

//    fun getById(id: Int): Player =
//        db.playerQueries
//            .selectById(id.toLong())

    fun add(name: String) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.playerQueries.insert(name)
    }

    fun delete(id: Int) =
        db.playerQueries.deleteById(id.toLong())
}