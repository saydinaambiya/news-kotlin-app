package com.enigmacamp.mynews.presentation.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enigmacamp.mynews.R
import com.enigmacamp.mynews.databinding.ActivityMainBinding
import com.enigmacamp.mynews.presentation.newssource.NewsSourceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, NewsSourceActivity::class.java)
        with(binding) {
            btnBusiness.setOnClickListener {
                Log.d("News", "Entertainment selected")
                intent.putExtra("category", "business")
                startActivity(intent)
            }
            btnEntertainment.setOnClickListener {
                Log.d("News", "Entertainment selected")
                intent.putExtra("category", "entertainment")
                startActivity(intent)
            }
            btnGeneral.setOnClickListener {
                Log.d("News", "General selected")
                intent.putExtra("category", "general")
                startActivity(intent)
            }
        }

    }
}
