package com.ruangaldo.video_youtube.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.databinding.ItemListArticleBinding
import com.ruangaldo.video_youtube.model.Article
import com.ruangaldo.video_youtube.utils.cacheImage

class AudioArticleListAdapter : RecyclerView.Adapter<AudioArticleListAdapter.ViewHolder>() {
    private var _items: MutableList<Article> = ArrayList()
    var onItemClick: ((Article) -> Unit)? = null
    private var _lastCheckedPosition = -1

    fun setArticleList(list: List<Article>) {
        this._items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_article, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(_items[position])

    override fun getItemCount(): Int = this._items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val _binding = ItemListArticleBinding.bind(view)
        fun bind(article: Article) {
            with(itemView) {
                _binding.apply {
                    ivThumbnail.cacheImage(article.thumbnail)
                    tvTitle.text = article.title
                    tvPublishedDate.text = article.publishedDate
                    tvStatus.text = article.status

                    if (_lastCheckedPosition == adapterPosition) {
                        layoutItemListArticle.setBackgroundColor(
                            ContextCompat.getColor(
                                context,
                                R.color.blue
                            )
                        )
                    } else {
                        layoutItemListArticle.setBackgroundColor(
                            ContextCompat.getColor(
                                context,
                                R.color.white
                            )
                        )
                    }
                }

                itemView.setOnClickListener {
                    onItemClick?.invoke(_items[adapterPosition])
                    _lastCheckedPosition = adapterPosition
                    notifyDataSetChanged()
                }
            }
        }
    }
}