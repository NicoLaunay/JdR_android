package com.example.jdr_android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jdr_android.controllers.PlayerViewModel
import com.example.jdr_android.views.PlayerScreen

@Composable
//@Preview
fun App(playerViewModel: PlayerViewModel) {

    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // TITRE APPLICATION
            Card() {
                Row() {
                    Text(
                        text = "⚔️",
                    )
                    Text(
                        text = "RPG Gestion",
                    )
                }
            }

            PlayerScreen(viewModel = playerViewModel)

        }
    }
}