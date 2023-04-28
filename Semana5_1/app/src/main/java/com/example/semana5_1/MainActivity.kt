package com.example.semana5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.semana5_1.Adapter.ContactAdapter
import com.example.semana5_1.Adapter.ContactAdapterListener

class MainActivity : AppCompatActivity(),ContactAdapterListener {

    private lateinit var adaptercontact: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var service: Placeholder
    private lateinit var contactList: ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contactList=ArrayList()
        contactList.add(Contact("Diego Talledo","178"))
        contactList.add(Contact("Alonzo Sanchez","93542647"))
        contactList.add(Contact("Estefano Ortiz","92405987"))

        val layoutManager=LinearLayoutManager(this)
        recyclerView=findViewById(R.id.recyclerContacts)
        recyclerView.layoutManager=layoutManager
        recyclerView.setHasFixedSize(true)
        adaptercontact= ContactAdapter(contactList,this@MainActivity)
        recyclerView.adapter=adaptercontact

    }

    override fun onActionItemClick(contact: Contact) {
        Toast.makeText(this,"Hola: "+contact.telephone, Toast.LENGTH_SHORT).show()
    }
}