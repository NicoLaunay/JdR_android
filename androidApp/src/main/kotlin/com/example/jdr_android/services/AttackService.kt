package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.enums.Stat
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Attack

class AttackService(private val db: JdrDatabase) {

    private val damageService = DamageService(db)

    fun getAll(): List<Attack> =
        db.attackQueries
            .selectAll()
            .executeAsList()
            .map { it.toModel(damageService.getAllByAttackId(it.id.toInt())) }

    fun getById(id: Int): Attack =
        db.attackQueries
            .selectById(id.toLong())
            .executeAsOne()
            .let { it.toModel(damageService.getAllByAttackId(it.id.toInt())) }

    fun getAllByWeaponId(weaponId: Int): List<Attack> =
        db.attackQueries
            .selectAllByWeaponId(weaponId.toLong())
            .executeAsList()
            .map { it.toModel(damageService.getAllByAttackId(it.id.toInt())) }

    fun add(weaponId: Int, stat: Stat, rangeMin: Int, rangeMax: Int, description: String) {
        require(description.isNotBlank()) { "La description ne peut pas être vide" }
        db.attackQueries.insert(
            weaponId.toLong(),
            stat.toString(),
            rangeMin.toLong(),
            rangeMax.toLong(),
            description
        )
    }

    fun delete(id: Int) =
        db.attackQueries.deleteById(id.toLong())
}
