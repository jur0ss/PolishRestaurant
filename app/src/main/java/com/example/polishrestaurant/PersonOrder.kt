package com.example.polishrestaurant

data class PersonOrder(
    val soup: Soup?,
    val mainDish: MainDish?,
    val drink: Drink?,
    val totalPrice: Double
)
