package com.example.sprint5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShoeAdapter(
    private val shoeList: List<Shoe>,
    private val onShoeClick: (Shoe) -> Unit
) : RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ShoeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe = shoeList[position]
        holder.bind(shoe, onShoeClick)
    }

    override fun getItemCount() = shoeList.size

    class ShoeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(shoe: Shoe, onShoeClick: (Shoe) -> Unit) {
            val shoeName = itemView.findViewById<TextView>(R.id.shoeName)
            val shoePrice = itemView.findViewById<TextView>(R.id.shoePrice)
            val shoeImage = itemView.findViewById<ImageView>(R.id.shoeImage)
            val viewButton = itemView.findViewById<Button>(R.id.viewButton)

            shoeName.text = shoe.name
            shoePrice.text = "$${shoe.price}"
            // Carga de imagen desde URL (Usa Glide o Picasso)
            Glide.with(itemView.context).load(shoe.imageUrl).into(shoeImage)

            viewButton.setOnClickListener {
                onShoeClick(shoe) // Accion al hacer clic en el botón "VER"
            }
        }
    }
}