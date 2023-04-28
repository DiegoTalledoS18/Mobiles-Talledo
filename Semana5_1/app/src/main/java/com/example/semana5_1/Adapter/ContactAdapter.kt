package com.example.semana5_1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.semana5_1.Contact
import com.example.semana5_1.R
import com.example.semana5_1.ViewHolders.ContactViewHolder

class ContactAdapter(
    val listaContacto: List<Contact>,
    val listener: ContactAdapterListener
    ):RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ContactViewHolder(layoutInflater.inflate(R.layout.prototype_contact,parent,false))
    }

    override fun getItemCount(): Int=listaContacto.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item=listaContacto[position]
        holder.btGreeting.setOnClickListener(){
            listener.onActionItemClick(listaContacto[position])
        }
        holder.render(item)
    }


}