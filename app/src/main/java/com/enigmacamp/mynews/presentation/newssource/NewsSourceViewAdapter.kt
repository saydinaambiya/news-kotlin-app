package com.enigmacamp.mynews.presentation.newssource

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enigmacamp.mynews.data.model.Source
import com.enigmacamp.mynews.databinding.SourcesViewHolderBinding

class NewsSourceViewAdapter(private val cellClick: (Source) -> Unit) :
    RecyclerView.Adapter<NewsSourceViewAdapter.ViewHolder>() {

    private var sources: MutableList<Source> = mutableListOf()

    inner class ViewHolder(val binding: SourcesViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SourcesViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return sources.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val source = sources[position]
        holder.binding.apply {
            tvSourceName.text = source.title
            tvSourceDescription.text = source.description
            btnViewArticles.setOnClickListener {
                cellClick(source)
            }
        }
    }

    fun submitData(newsSource: List<Source>) {
        sources.clear()
        sources.addAll(newsSource)
    }
}