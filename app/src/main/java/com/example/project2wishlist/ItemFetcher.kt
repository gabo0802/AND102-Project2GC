package com.example.project2wishlist

class ItemFetcher {
    companion object {
        val name = listOf("EX 'Shoes'")
        val link = listOf("EX 'Amazon.com'")
        val price = listOf("EX '5.99'")

        fun getItem(): MutableList<Item> {
            var items : MutableList<Item> = ArrayList()
            for(i in 0 until 1) {
                val item = Item(name[i], link[i],  price[i])
                items.add(item)
            }
            return items
        }
    }
}