package com.example.polishrestaurant

data class Order(
    val orders: MutableList<PersonOrder> = mutableListOf()
) {

    fun addOrder(order: PersonOrder) {
        orders.add(order)
    }
}