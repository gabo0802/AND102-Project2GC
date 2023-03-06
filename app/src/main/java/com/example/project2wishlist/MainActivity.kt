package com.example.project2wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items : List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.ItemsRv)

        items = ItemFetcher.getItem()

        val adapter = ItemAdapter(items)

        itemsRv.adapter = adapter

        itemsRv.layoutManager = LinearLayoutManager(this)

        itemsRv.setOnLongClickListener {
            print("we are here")
            AdapterView.OnItemLongClickListener{ _, _, index, _ ->
                Toast.makeText(applicationContext, "Long clicked on ${items[index]}", Toast.LENGTH_SHORT).show()
                true
            }
            return@setOnLongClickListener true
        }
        findViewById<Button>(R.id.addButton).setOnClickListener {

            var newName = findViewById<TextView>(R.id.itemName).text.toString()
            var newLink = findViewById<TextView>(R.id.itemLink).text.toString()
            var newPrice ="$" + findViewById<TextView>(R.id.itemPrice).text.toString()

            val newItem = Item(newName, newLink, newPrice)
            // Add new item to existing list of emails
            (items as MutableList<Item>).add(newItem)
            // Notify the adapter there's a new item so the RecyclerView layout is updated
            adapter.notifyDataSetChanged()
        }
    }
}