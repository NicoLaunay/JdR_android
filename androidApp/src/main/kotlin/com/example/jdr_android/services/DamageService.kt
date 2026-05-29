package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.enums.DamageType
import com.example.jdr_android.enums.DiceType
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Damage

class DamageService(private val db: JdrDatabase) {

    fun getAll(): List<Damage> =
        db.damageQueries
            .selectAll()
            .executeAsList()
            .map { it.toModel() }

//    fun getById(id: Int): Damage =
//        db.damageQueries
//            .selectById(id.toLong())
//            .executeAsOne()
//            .toModel()

    fun getAllByAttackId(attackId: Int): List<Damage> =
        db.damageQueries
            .selectAllByAttackId(attackId.toLong())
            .executeAsList()
            .map { it.toModel() }

    fun add(attackId: Int, diceType: DiceType, nbDice: Int, modifier: Int, type: DamageType) {
        db.damageQueries.insert(
            attackId.toLong(),
            diceType.toString(),
            nbDice.toLong(),
            modifier.toLong(),
            type.toString()
        )
    }

    fun delete(id: Int) =
        db.damageQueries.deleteById(id.toLong())
}
