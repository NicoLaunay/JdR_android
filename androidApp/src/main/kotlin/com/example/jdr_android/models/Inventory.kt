package models

data class Inventory(
    var copperCoinsNb: Int,
    var silverCoinsNb: Int,
    var goldCoinsNb: Int,
    var platinumCoinsNb: Int,
    var items: List<String>
)
