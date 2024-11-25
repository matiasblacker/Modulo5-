package com.example.ejercicioindividual15

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioindividual15.databinding.ItemPersonBinding

class PersonAdapter(private val personList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(private val binding: ItemPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.textViewName.text = "Nombre: ${person.name} |"
            binding.textViewSurname.text = "Apellido: ${person.surname} |"
            binding.textViewAge.text = "Edad: ${person.age}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}