package com.example.semana5_1.ViewHolders

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import com.example.semana5_1.Contact
import com.example.semana5_1.R

class ContactViewHolder(view: View):RecyclerView.ViewHolder(view) {
    lateinit var service: Placeholder
    val tvName=view.findViewById<TextView>(R.id.tvName)
    val tvTelefone=view.findViewById<TextView>(R.id.tvTelefone)
    val btGreeting=view.findViewById<Button>(R.id.btGreeting)

    fun render(ContactModel: Contact){
        tvName.text=ContactModel.name
        tvTelefone.text=ContactModel.telephone
    }
}