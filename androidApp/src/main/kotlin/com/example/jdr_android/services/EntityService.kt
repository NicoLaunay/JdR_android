package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toEntityPath
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.EntityPath
import com.example.jdr_android.models.Entity

class EntityService(private val db: JdrDatabase) {

    private val raceService = RaceService(db)
    private val weaponService = WeaponService(db)
    private val armorService = ArmorService(db)
    private val skillService = SkillService(db)

    fun getById(id: Int, paths: List<EntityPath>): Entity =
        db.entityQueries
            .selectById(id.toLong())
            .executeAsOne()
            .let { entity ->
                entity.toModel(
                    race = raceService.getById(entity.id_race?.toInt() ?: 1),
                    weapons = weaponService.getAllByOwnerId(id),
                    armors = armorService.getAllByOwnerId(id),
                    paths = paths,
                )
            }

    fun getPathsByEntityId(entityId: Int): List<EntityPath> =
        db.entityKnowsPathQueries
            .selectPathsByEntity(entityId.toLong())
            .executeAsList()
            .map { row ->
                row.toEntityPath(
                    entityId = entityId,
                    skills = skillService.getAllByPathId(row.id.toInt())
                )
            }

    fun add(entity: Entity) {
        require(entity.name.isNotBlank()) { "Le nom ne peut pas être vide" }
        db.entityQueries.insert(
            entity.race.id.toLong(),
            entity.name,
            entity.level,
            entity.age?.toLong(),
            entity.weight?.toDouble(),
            entity.sex.toString(),
            entity.type.toString(),
            entity.size.toString(),
            entity.strength.toLong(),
            entity.dexterity.toLong(),
            entity.constitution.toLong(),
            entity.intelligence.toLong(),
            entity.wisdom.toLong(),
            entity.charisma.toLong(),
            entity.pvMax.toLong(),
            entity.pv.toLong(),
            entity.copperCoinsNb.toLong(),
            entity.silverCoinsNb.toLong(),
            entity.goldCoinsNb.toLong(),
            entity.platinumCoinsNb.toLong(),
            entity.items.joinToString(", ")
        )
    }

    fun updatePv(id: Int, pv: Int) =
        db.entityQueries.updatePv(pv.toLong(), id.toLong())

    fun updateLevel(id: Int, level: Double, pvMax: Int) =
        db.entityQueries.updateLevel(level, pvMax.toLong(), id.toLong())

    fun delete(id: Int) =
        db.entityQueries.deleteById(id.toLong())
}
