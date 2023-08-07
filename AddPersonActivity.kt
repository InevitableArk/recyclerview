package com.example.words

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.words.databinding.ActivityMainBinding
import com.example.words.databinding.AddPersonBinding

class AddPersonActivity : AppCompatActivity() {
    private lateinit var binding : AddPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(){
            val personName = binding.etName.toString()
            val personAge = binding.etAge.toString().toInt()

            val person = Person(personName, personAge)
            val result = Intent().putExtra("EXTRA_NAME", person)
            setResult(Activity.RESULT_OK, result)
        }
    }
}
