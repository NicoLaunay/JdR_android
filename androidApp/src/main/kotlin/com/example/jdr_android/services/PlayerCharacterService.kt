package com.example.jdr_android.services

import com.example.jdr_android.db.JdrDatabase
import com.example.jdr_android.mappers.toModel
import com.example.jdr_android.models.PlayerCharacter

class PlayerCharacterService(private val db: JdrDatabase) {

    private val entityService = EntityService(db)
    private val playerService = PlayerService(db)
    private val profileService = ProfileService(db)

    fun getAll(): List<PlayerCharacter> =
        db.playableCharacterQueries
            .selectAll()
            .executeAsList()
            .map { pc ->
                pc.toModel(
                    entity = entityService.getById(pc.id_entity.toInt(), emptyList()),
                    player = playerService.getById(pc.id_player.toInt()),
                    profile = profileService.getById(pc.id_profile.toInt())
                )
            }

    fun getById(entityId: Int): PlayerCharacter =
        db.playableCharacterQueries
            .selectById(entityId.toLong())
            .executeAsOne()
            .let { pc ->
                pc.toModel(
                    entity = entityService.getById(
                        pc.id_entity.toInt(),
                        entityService.getPathsByEntityId(pc.id_entity.toInt())),
                    player = playerService.getById(pc.id_player.toInt()),
                    profile = profileService.getById(pc.id_profile.toInt())
                )
            }

    fun getAllByPlayer(playerId: Int): List<PlayerCharacter> =
        db.playableCharacterQueries
            .selectAllByPlayer(playerId.toLong())
            .executeAsList()
            .map { pc ->
                pc.toModel(
                    entity = entityService.getById(
                        pc.id_entity.toInt(),
                        entityService.getPathsByEntityId(pc.id_entity.toInt())),
                    player = playerService.getById(pc.id_player.toInt()),
                    profile = profileService.getById(pc.id_profile.toInt())
                )
            }

    fun add(
        entityId: Int,
        playerId: Int,
        profileId: Int,
        coinsCopper: Int = 0,
        coinsSilver: Int = 0,
        coinsGold: Int = 0,
        coinsPlatinum: Int = 0,
        pcMax: Int = 0, pc: Int = 0,
        prMax: Int = 0, pr: Int = 0,
        pmMax: Int = 0, pm: Int = 0
    ) {
        db.playableCharacterQueries.insert(
            entityId.toLong(),
            playerId.toLong(),
            profileId.toLong(),
            pcMax.toLong(), pc.toLong(),
            prMax.toLong(), pr.toLong(),
            pmMax.toLong(), pm.toLong()
        )
    }

    fun updateCoins(entityId: Int, copper: Int, silver: Int, gold: Int, platinum: Int) =
        db.entityQueries.updateCoins(
            copper.toLong(),
            silver.toLong(),
            gold.toLong(),
            platinum.toLong(),
            entityId.toLong()
        )

    fun delete(entityId: Int) =
        db.playableCharacterQueries.deleteById(entityId.toLong())
}
