package com.example.polishrestaurant

data class Soup(
    val id: Int,
    val name: String,
    val price: Double
)
val soupsList = listOf(
    Soup(1, "rybna", 12.0),
    Soup(2, "pomidorowa", 10.0),
    Soup(3, "rosół", 9.0),
    Soup(4, "grzybowa", 13.0),
    Soup(5, "barszcz czerwony", 11.0),
    Soup(6, "krupnik", 10.5),
    Soup(7, "żurek", 12.5),
    Soup(8, "fasolowa", 11.0),
    Soup(9, "ogórkowa", 10.0),
    Soup(10, "brokułowa", 12.0),
)