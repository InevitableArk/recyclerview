package com.example.hello

import android.app.Person
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello.databinding.ActivityMainBinding

data class Person(val name: String, val age: Int)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contacts = createContacts()
        binding.rvContacts.adapter = ContactsAdapter(this, createContacts())
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(){
        val contacts:MutableList<Person> = mutableListOf<Person>()
        for(i:Int in 1..100){
            contacts.add(Person("Person $i",i))
        }
    }

}
