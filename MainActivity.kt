package com.example.words

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.words.databinding.ActivityMainBinding
import java.io.Serializable

data class Person(val name:String,val age:Int):Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contacts:MutableList<Person> = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val person = createPerson()
        binding.rvPerson.adapter = PersonAdapter(this, person)
        binding.rvPerson.layoutManager = LinearLayoutManager(this)
    }

    private fun createPerson():List<Person>{
        for (i in 1..100) {
            val person = Person("Person $i", i)
            contacts.add(person)
        }
        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.miAdd){
            val myIntent = Intent(this, AddPersonActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
