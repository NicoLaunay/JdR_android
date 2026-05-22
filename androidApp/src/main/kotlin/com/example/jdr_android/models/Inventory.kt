package com.example.jdr_android.models

data class Inventory(
    val id: Int,
    var copperCoinsNb: Int,
    var silverCoinsNb: Int,
    var goldCoinsNb: Int,
    var platinumCoinsNb: Int,
    var items: List<String>
)
