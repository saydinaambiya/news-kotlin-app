package com.enigmacamp.mynews.presentation.newssource

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.enigmacamp.mynews.common.ViewState
import com.enigmacamp.mynews.databinding.ActivityNewsSourceBinding
import com.enigmacamp.mynews.di.SourceCategoryFactory
import com.enigmacamp.mynews.presentation.article.ArticleActivity
import com.enigmacamp.mynews.presentation.article.ArticleWebViewActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewsSourceActivity : DaggerAppCompatActivity() {
    lateinit var viewModel: NewsSourceViewModel

    @Inject
    lateinit var sourceCategoryFactory: SourceCategoryFactory

    private lateinit var binding: ActivityNewsSourceBinding

    private val adapter = NewsSourceViewAdapter {
//        val intent = Intent(this, ArticleWebViewActivity::class.java)
//        intent.putExtra("url", it.url)
//        startActivity(intent)
        val uri = Uri.parse(it.url)
        val i = Intent(Intent.ACTION_VIEW, uri)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsSourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvSources.layoutManager = LinearLayoutManager(this@NewsSourceActivity)
            rvSources.adapter = adapter

            btnSearchSource.setOnClickListener {
                val sourceKey = etSourceKey.text.toString()
                viewModel.findNewsSource(sourceKey)
            }
        }
        val category = intent.getStringExtra("category")

        category?.let {
            viewModel = ViewModelProvider(
                this,
                NewsSourceViewModel.factory(setupNewsSourceViewModel(it))
            )[NewsSourceViewModel::class.java]
        }
        subscribe()
    }

    private fun setupNewsSourceViewModel(category: String): NewsSourceViewModel {
        return sourceCategoryFactory.create(category)
    }

    private fun subscribe() {
        viewModel.result.observe(this) {
            when (it) {
                is ViewState.Loading -> {
                    binding.pbNewsSource.visibility = View.VISIBLE
                }
                is ViewState.Success -> {
                    adapter.submitData(it.data)
                    adapter.notifyDataSetChanged()
                    binding.pbNewsSource.visibility = View.INVISIBLE
                }
                is ViewState.Error -> {
                    Log.d("News", "Error: ${it.errorMessage}")
                    binding.pbNewsSource.visibility = View.INVISIBLE
                }
            }
        }
    }
}