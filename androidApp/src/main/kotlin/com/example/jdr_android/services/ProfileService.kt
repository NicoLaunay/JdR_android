package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.enums.DiceType
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.Profile

class ProfileService(private val db: JdrDatabase) {

    private val pathService = PathService(db)
    private val armorService = ArmorService(db)
    private val weaponService = WeaponService(db)

    fun getAll(): List<Profile> =
        db.profileQueries
            .selectAll()
            .executeAsList()
            .map { profile ->
                profile.toModel(
                    paths = pathService.getAllByProfileId(profile.id.toInt()),
                    starterWeapons = weaponService.getStartersByProfileId(profile.id.toInt()),
                    starterArmors = armorService.getStartersByProfileId(profile.id.toInt())
                )
            }

    fun getById(id: Int): Profile =
        db.profileQueries
            .selectById(id.toLong())
            .executeAsOne()
            .toModel(
                paths = pathService.getAllByProfileId(id),
                starterWeapons = weaponService.getStartersByProfileId(id),
                starterArmors = armorService.getStartersByProfileId(id)
            )

    fun add(name: String, lifeDice: DiceType) {
        require(name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.profileQueries.insert(name, lifeDice.toString())
    }

    fun delete(id: Int) =
        db.profileQueries.deleteById(id.toLong())
}
