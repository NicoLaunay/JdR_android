package com.example.jdr_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.jdr_android.controllers.PlayerViewModel
import com.example.jdr_android.services.PlayerService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val db = (application as JdrApplication).database

        val playerViewModel: PlayerViewModel by viewModels {
            viewModelFactory {
                initializer { PlayerViewModel(PlayerService(db)) }
            }
        }

        setContent {
            App(playerViewModel)
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App()
//}