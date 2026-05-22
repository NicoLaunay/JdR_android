package com.example.jdr_android

import com.example.jdr_android.db.JdrDatabase

fun initData(db: JdrDatabase) {

    // --- RACES ---
    if (db.raceQueries.selectAll().executeAsList().isEmpty()) {
        // N'insère que si la BDD est vide — évite les doublons au redémarrage
        db.raceQueries.insert("Demi-Elfe", 0, 0, -2, 0, 2, 0)
        db.raceQueries.insert("Demi-Orque", 2, 0, 0, -2, 0, -2)
        db.raceQueries.insert("Haut Elfe", -2, 0, 0, 0, 0, 2)
        db.raceQueries.insert("Elfe Sylvain", -2, 2, 0, 0, 0, 0)
        db.raceQueries.insert("Gnome", -2, 0, 0, 2, 0, 0)
        db.raceQueries.insert("Halfelin", -2, 2, 0, 0, 0, 0)
        db.raceQueries.insert("Humain", 0, 0, 0, 0, 0, 0)
        db.raceQueries.insert("Nain", 0, -2, 2, 0, 0, 0)
    }

    // --- CAPACITES RACIALES ---
    if (db.racialAbilityQueries.selectAll().executeAsList().isEmpty()) {

        db.racialAbilityQueries.insert(
            "Lumière des étoiles",
            "Pour le personnage, l’obscurité de la nuit sous la lumière des étoiles " +
                    "n’est que de la pénombre, où seuls les petits détails lui échappent."
        )
        db.racialAbilityQueries.insert(
            "Instinct de survie",
            "Lorsqu’une attaque devrait amener le personnage à 0 PV, les DM qu’elle " +
                    "inflige sont divisés par 2 (minimum 1)."
        )
        db.racialAbilityQueries.insert(
            "Vision dans le noir",
            "Dans le noir total, le personnage voit comme dans la pénombre jusqu’à 30 m."
        )
        db.racialAbilityQueries.insert(
            "Don étrange",
            "le personnage possède un talent inné pour les sciences, qu’elles soient " +
                    "occultes ou plus ordinaires.\n" +
                    "Le joueur choisit une des deux options suivantes :\n" +
                    "   - Soit son personnage gagne un bonus de +5 sur tous les tests d’INT ;\n" +
                    "   - Soit il choisit une capacité de rang 1 d’Ensorceleur. Il peut utiliser ce sort " +
                    "sans pénalité avec une armure allant jusqu’à la chemise de maille."
        )
        db.racialAbilityQueries.insert(
            "Petite taille",
            "le personnage obtient un bonus de +1 en DEF et de +2 à tous les tests de " +
                    "discrétion. En revanche, il peut seulement utiliser à une main une arme dont " +
                    "les DM sont au maximum égaux à 1d6 (épée courte, masse, etc.). Il lui faut " +
                    "utiliser les 2 mains pour les armes qui infligent 1d8 à 1d10 de DM (épée " +
                    "longue). Enfin il lui est interdit d’utiliser les armes qui infligent plus de " +
                    "1d10 DM."
        )
    }

    // --- LIENS RACE -> CAPACITES RACIALES
    if (db.racePossessesAbilityQueries.selectAll().executeAsList().isEmpty()) {
        db.racePossessesAbilityQueries.linkRaceToAbility(1, 1)
        db.racePossessesAbilityQueries.linkRaceToAbility(1, 2)
        db.racePossessesAbilityQueries.linkRaceToAbility(2, 3)
        db.racePossessesAbilityQueries.linkRaceToAbility(3, 1)
        db.racePossessesAbilityQueries.linkRaceToAbility(4, 1)
        db.racePossessesAbilityQueries.linkRaceToAbility(5, 4)
        db.racePossessesAbilityQueries.linkRaceToAbility(6, 5)
        db.racePossessesAbilityQueries.linkRaceToAbility(7, 2)
        db.racePossessesAbilityQueries.linkRaceToAbility(8, 3)
    }

}