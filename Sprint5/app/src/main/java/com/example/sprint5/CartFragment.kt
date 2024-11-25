package com.example.sprint5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CartFragment : Fragment() {

    private lateinit var cartAdapter: CartAdapter
    private val cartItems = Cart.getItems()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        cartAdapter = CartAdapter(cartItems)
        recyclerView.adapter = cartAdapter


        val totalPriceTextView: TextView = view.findViewById(R.id.totalPrice)
        val totalPrice = cartItems.sumOf { it.price }
        totalPriceTextView.text = "Total: $$totalPrice"


        val checkoutButton: Button = view.findViewById(R.id.checkoutButton)
        checkoutButton.setOnClickListener {

        }
    }

    inner class CartAdapter(private val cartItems: List<Shoe>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
            return CartViewHolder(view)
        }

        override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
            val shoe = cartItems[position]
            holder.bind(shoe)
        }

        override fun getItemCount() = cartItems.size

        inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val shoeImage: ImageView = itemView.findViewById(R.id.shoeImage)
            private val shoeName: TextView = itemView.findViewById(R.id.shoeName)
            private val shoePrice: TextView = itemView.findViewById(R.id.shoePrice)

            fun bind(shoe: Shoe) {
                // Cargar la imagen usando Glide
                Glide.with(itemView.context)
                    .load(shoe.imageUrl)
                    .into(shoeImage)

                shoeName.text = shoe.name
                shoePrice.text = "$${shoe.price}"
            }
        }
    }
}