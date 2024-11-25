package com.example.sprint5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprint5.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    private lateinit var shoeAdapter: ShoeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inicializar ViewBinding
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)

        // Inicializar RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        // Obtener la lista de zapatos
        val shoeList = getShoeList()


        shoeAdapter = ShoeAdapter(shoeList) { shoe ->
            openShoeDetailFragment(shoe)
        }
        binding.recyclerView.adapter = shoeAdapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpiar el binding
    }

    // Función que navega al fragmento de detalle del zapato
    private fun openShoeDetailFragment(shoe: Shoe) {
        // Navegar
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(shoe)
        findNavController().navigate(action)
    }

    // Lista de zapatillas
    private fun getShoeList(): List<Shoe> {
        return listOf(
            Shoe("Zapatilla Super Star", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/137962562_01/w=1500,h=1500,fit=pad", 59.990),
            Shoe("Zapatilla Urbana Hombre", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/50259614_1/w=1500,h=1500,fit=pad", 49.990),
            Shoe("Zapatilla Adidas Sambae", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/80260766_1/w=1500,h=1500,fit=pad", 49.990),
            Shoe("Zapatilla Adidas VI court 3.0", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/50348551_1/w=1500,h=1500,fit=pad", 69.990),
            Shoe("Zapatilla Adidas NY 90", "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaCL/80050046_1/w=1500,h=1500,fit=pad", 41.990)
        )
    }
}