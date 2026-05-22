package com.example.jdr_android.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jdr_android.controllers.PlayerViewModel

@Composable
fun PlayerScreen(viewModel: PlayerViewModel) {

    val players by viewModel.players.collectAsStateWithLifecycle()
    var newName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = newName,
                onValueChange = { newName = it },
                label = { Text("Nom du joueur") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newName.isNotBlank()) {
                    viewModel.add(newName)
                    newName = ""
                }
            }) {
                Text("Ajouter")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(players) { player ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(player.name)
                    TextButton(onClick = { viewModel.delete(player.id) }) {
                        Text("Supprimer")
                    }
                }
            }
        }
    }
}