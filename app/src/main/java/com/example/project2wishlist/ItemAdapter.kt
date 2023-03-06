package com.example.project2wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val wishList : List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.

        val itemTextView: TextView
        val linkTextView: TextView
        val priceTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemTextView = itemView.findViewById(R.id.itemNameTv)
            linkTextView = itemView.findViewById(R.id.itemLinkTv)
            priceTextView = itemView.findViewById(R.id.itemPriceTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return wishList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val wish = wishList.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = wish.name
        holder.linkTextView.text = wish.link
        //Currently not parsing the double yet
        holder.priceTextView.text = wish.price
    }


}