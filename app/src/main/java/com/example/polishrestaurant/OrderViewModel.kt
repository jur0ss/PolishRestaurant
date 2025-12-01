package com.example.polishrestaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel()
{
    private val _currentSoup = MutableLiveData<Soup?>()
    val currentSoup: LiveData<Soup?> = _currentSoup

    private val _currentMain = MutableLiveData<MainDish?>()
    val currentMain: LiveData<MainDish?> = _currentMain

    private val _currentDrink = MutableLiveData<Drink?>()
    val currentDrink: LiveData<Drink?> = _currentDrink

    private val _currentTotal = MutableLiveData<Double>(0.0)
    val currentTotal: LiveData<Double> = _currentTotal

    private val _orderList = MutableLiveData<Order>(Order())
    val orderList: LiveData<Order> = _orderList


    fun setSoup(soup: Soup) {
        _currentSoup.value = soup
        recalculateTotal()
    }

    fun setMainDish(main: MainDish) {
        _currentMain.value = main
        recalculateTotal()
    }

    fun setDrink(drink: Drink) {
        _currentDrink.value = drink
        recalculateTotal()
    }

    private fun recalculateTotal() {
        val soup = _currentSoup.value?.price ?: 0.0
        val main = _currentMain.value?.price ?: 0.0
        val drink = _currentDrink.value?.price ?: 0.0
        _currentTotal.value = soup + main + drink
    }


    fun confirmOrder() {
        val order = PersonOrder(
            soup = _currentSoup.value,
            mainDish = _currentMain.value,
            drink = _currentDrink.value,
            totalPrice = _currentTotal.value ?: 0.0
        )

        _orderList.value?.addOrder(order)

        clearCurrent()
    }

    fun clearCurrent() {
        _currentSoup.value = null
        _currentMain.value = null
        _currentDrink.value = null
        _currentTotal.value = 0.0
    }


}
