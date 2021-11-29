package com.example.codechallenge2.ui.adapters

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codechallenge2.R
import com.example.codechallenge2.ui.models.ProductsResponseItem
import kotlinx.android.synthetic.main.item_article_preview.view.*

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<ProductsResponseItem>(){
        override fun areItemsTheSame(
            oldItem: ProductsResponseItem,
            newItem: ProductsResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductsResponseItem,
            newItem: ProductsResponseItem
        ): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_article_preview,
                parent,
                false
            )
        )
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.image).into(ivArticleImage)
            tvTitle.text = article.title
            tvDescription.text = article.description
            tvCategory.text = article.category
            tvPrice.text = article.price.toString()
            tvRating.text = article.rating.toString()
            setOnClickListener {
                onItemClickListener?.let { it(article) }
            }

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((ProductsResponseItem)->Unit)? = null

    fun setOnItemClickListener(listener: (ProductsResponseItem)->Unit){
        onItemClickListener = listener
    }
}