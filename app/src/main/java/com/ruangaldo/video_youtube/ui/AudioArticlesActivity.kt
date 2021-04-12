package com.ruangaldo.video_youtube.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.ActivityAudioArticlesBinding
import com.ruangaldo.video_youtube.ui.adapter.AudioArticleListAdapter
import com.ruangaldo.video_youtube.viewmodel.ArticleViewModel


class AudioArticlesActivity : BaseFragment<ActivityAudioArticlesBinding>() {

    private lateinit var _viewModelArticle: ArticleViewModel
    private lateinit var _adapter: AudioArticleListAdapter

//    override val bindingInflater: (LayoutInflater) -> ActivityAudioArticlesBinding
//        get() = ActivityAudioArticlesBinding::inflate

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ActivityAudioArticlesBinding
        get() = ActivityAudioArticlesBinding::inflate

    override fun setup() {

//        setSupportActionBar(binding.myToolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)

        _viewModelArticle = ViewModelProvider(this).get(ArticleViewModel::class.java)
        _adapter = AudioArticleListAdapter().apply {
            onItemClick = {
                Toast.makeText(requireActivity(), it.title, Toast.LENGTH_LONG).show()
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
        val playScreen= PlayerScreen()
        binding.ivBack.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,playScreen)
                .commitNowAllowingStateLoss()
            Log.e("Tes back","bisa ga?")
        }
    }
}