package com.joe.databinding.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object FakeRepository {
    private val fruitNames: List<String> =
        listOf("Apple", "Banana", "Fig", "Gooseberry", "Grapes", "Kiwi", "Orange", "Pear", "Raspberry", "Strawberry")

    private val currentFruit = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        get() = currentFruit

    init {
        currentFruit.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        currentFruit.value = getRandomFruitName()
    }
}
