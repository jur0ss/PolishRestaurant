package com.example.polishrestaurant

data class Drink(
    val id: Int,
    val name: String,
    val price: Double
)

val drinksList = listOf(
    Drink(1, "Kompot z suszu", 6.0),
    Drink(2, "Kisiel", 5.0),
    Drink(3, "Miód pitny", 15.0),
    Drink(4, "Sok z aronii", 7.0),
    Drink(5, "Sok z czarnej porzeczki", 7.0),
    Drink(6, "Woda mineralna", 5.0),
    Drink(7, "Herbata czarna", 6.0),
    Drink(8, "Herbata ziołowa", 6.0),
    Drink(9, "Kawa zbożowa", 6.0),
    Drink(10, "Cydr jabłkowy", 10.0)
)
