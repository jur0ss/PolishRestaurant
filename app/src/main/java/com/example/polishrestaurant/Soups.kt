package com.example.polishrestaurant

data class Soup(
    val id: Int,
    val name: String,
    val price: Double
)
val soupsList = listOf(
    Soup(1, "Rybna", 12.0),
    Soup(2, "Pomidorowa", 10.0),
    Soup(3, "Rosół", 9.0),
    Soup(4, "Grzybowa", 13.0),
    Soup(5, "Barszcz czerwony", 11.0),
    Soup(6, "Krupnik", 10.5),
    Soup(7, "Żurek", 12.5),
    Soup(8, "Fasolowa", 11.0),
    Soup(9, "Ogórkowa", 10.0),
    Soup(10, "Brokułowa", 12.0),
)