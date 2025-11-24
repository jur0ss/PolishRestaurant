package com.example.polishrestaurant

data class MainDish(
    val id: Int,
    val name: String,
    val price: Double
)

val mainDishesList = listOf(
    MainDish(1, "Schabowy z ziemniakami i surówką", 25.0),
    MainDish(2, "Pierogi ruskie", 20.0),
    MainDish(3, "Gołąbki w sosie pomidorowym", 22.0),
    MainDish(4, "Kotlet mielony z ziemniakami", 24.0),
    MainDish(5, "Placki ziemniaczane ze śmietaną", 18.0),
    MainDish(6, "Karkówka z grilla", 28.0),
    MainDish(7, "Ryba po polsku", 26.0),
    MainDish(8, "Gulasz wołowy z kaszą", 27.0),
    MainDish(9, "Naleśniki z serem lub mięsem", 19.0),
    MainDish(10, "Bigos staropolski", 23.0)
)