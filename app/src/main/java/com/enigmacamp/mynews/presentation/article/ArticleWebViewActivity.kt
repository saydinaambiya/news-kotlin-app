package com.enigmacamp.mynews.presentation.article

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmacamp.mynews.databinding.ActivityArticleWebViewBinding

class ArticleWebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val url = intent.getStringExtra("url")
        binding.wvArticle.loadUrl(url!!)
    }
}