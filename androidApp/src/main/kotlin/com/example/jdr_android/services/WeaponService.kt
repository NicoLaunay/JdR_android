package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Armor
import com.example.jdr_android.models.Weapon

class WeaponService(private val db: JdrDatabase) {

    private val attackService = AttackService(db)

    fun getAll(): List<Weapon> =
        db.weaponQueries
            .selectAll()
            .executeAsList()
            .map { it.toModel(attackService.getAllByWeaponId(it.id.toInt())) }

    fun getById(id: Int): Weapon =
        db.weaponQueries
            .selectById(id.toLong())
            .executeAsOne()
            .let { it.toModel(attackService.getAllByWeaponId(it.id.toInt())) }

    fun getStartersByProfileId(profileId: Int): List<Weapon> =
        db.weaponQueries
            .selectStartersByProfileId(profileId.toLong())
            .executeAsList()
            .map { it.toModel(attackService.getAllByWeaponId(it.id.toInt())) }

    fun getAllByOwnerId(ownerId: Int): List<Weapon> =
        db.weaponQueries
            .selectAllByOwnerId(ownerId.toLong())
            .executeAsList()
            .map {
                it.toModel(attackService.getAllByWeaponId(it.id.toInt()))
            }

    fun add(name: String, description: String) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.weaponQueries.insert(name, description)
    }

    fun delete(id: Int) =
        db.weaponQueries.deleteById(id.toLong())
}
