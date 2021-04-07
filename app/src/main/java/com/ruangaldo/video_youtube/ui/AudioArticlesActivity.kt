package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruangaldo.video_youtube.base.BaseActivity
import com.ruangaldo.video_youtube.databinding.ActivityAudioArticlesBinding
import com.ruangaldo.video_youtube.ui.adapter.AudioArticleListAdapter
import com.ruangaldo.video_youtube.viewmodel.ArticleViewModel

class AudioArticlesActivity : BaseActivity<ActivityAudioArticlesBinding>() {

    private lateinit var _viewModelArticle: ArticleViewModel
    private lateinit var _adapter: AudioArticleListAdapter

    override val bindingInflater: (LayoutInflater) -> ActivityAudioArticlesBinding
        get() = ActivityAudioArticlesBinding::inflate

    override fun setup() {
        _viewModelArticle = ViewModelProvider(this).get(ArticleViewModel::class.java)
        _adapter = AudioArticleListAdapter().apply {
            onItemClick = {
                Toast.makeText(this@AudioArticlesActivity, it.title, Toast.LENGTH_LONG).show();
            }
        }

        with(binding.rvAudioArticles) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = _adapter
        }

        _viewModelArticle.getDummyAudioArticles().observe(this, {
            _adapter.setArticleList(it)
        })
    }
}