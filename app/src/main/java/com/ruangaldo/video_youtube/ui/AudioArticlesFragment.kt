package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentAudioArticlesBinding
import com.ruangaldo.video_youtube.ui.adapter.AudioArticleListAdapter
import com.ruangaldo.video_youtube.viewmodel.ArticleViewModel


class AudioArticlesFragment : BaseFragment<FragmentAudioArticlesBinding>() {

    private lateinit var _viewModelArticle: ArticleViewModel
    private lateinit var _adapter: AudioArticleListAdapter

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAudioArticlesBinding
        get() = FragmentAudioArticlesBinding::inflate

    override fun setup() {
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

        /**
         * Exit Audio Articles Fragment by using popBackStack().
         * First add .addToBackStack(null) in function initPlaylist() located in FirstPageFirstFragment.
         *
         * Using parentFragmentManager (replacement deprecated fragmentManager),
         * Source: https://stackoverflow.com/a/60055145
         *
         * Call exitPlaylist() function from parentFragment PlayerScreen to transition from minimize to maximize.
         */
        binding.ivBack.setOnClickListener {
            parentFragmentManager.popBackStack()

            (parentFragment as PlayerScreen).exitPlaylist()
        }
    }
}