package com.enigmacamp.mynews.presentation.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enigmacamp.mynews.R

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        val sourceId = intent.getStringExtra("sourceId")
        Log.d("news", "Source Id: $sourceId")
    }
}