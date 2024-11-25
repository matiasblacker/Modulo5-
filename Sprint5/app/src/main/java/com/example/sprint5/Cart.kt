package com.example.sprint5

object Cart {
    private val items: MutableList<Shoe> = mutableListOf()

    fun addItem(shoe: Shoe) {
        items.add(shoe)
    }

    fun getItems(): List<Shoe> {
        return items
    }
}