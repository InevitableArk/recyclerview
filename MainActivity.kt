package com.example.words

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.words.databinding.ActivityMainBinding

data class Person(val name:String,val age:Int)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contacts:MutableList<Person> = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        val person = createPerson()
        binding.rvPerson.adapter = PersonAdapter(this, person)
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
    }

    private fun createPerson():List<Person>{
        for (i in 1..10) {
            val person = Person("Person $i", i)
            contacts.add(person)
        }
        return contacts
    }
}
