package com.example.jdr_android.models

import androidx.compose.ui.graphics.Path

data class CharacterPath(
    val idCharacter: Int,
    val path: Path,
    val levelReached: Int
)
