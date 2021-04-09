package com.ruangaldo.video_youtube.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentPlayerScreenBinding
import com.ruangaldo.video_youtube.model.Article
import com.ruangaldo.video_youtube.utils.cacheImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class PlayerScreen : BaseFragment<FragmentPlayerScreenBinding>() {

    companion object {
        const val EXTRA_ARTICLE = "extra_article"
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlayerScreenBinding
        get() = FragmentPlayerScreenBinding::inflate

    override fun setup() {
        if (arguments != null) {
            val article: Article = requireArguments().getParcelable(EXTRA_ARTICLE)!!

            binding.ivAlbum.cacheImage(article.thumbnail)

            article.title.let {
                binding.tvTittle.text = it
                binding.tvTittleMin.text = it
            }
           /* val intent=Intent(requireActivity(),AudioArticlesActivity::class.java)
            binding.tvAnotherArticle.setOnClickListener {
                startActivity(intent)
            }*/

            binding.tvAnotherArticle.setOnClickListener {
                // Call func changeToPlayList() from FirstPageFirstFragment to replace parent layout.
                (parentFragment as FirstPageFirstFragment).changeToPlaylist()

                // Call transition to start (minimize) programatically.
                lifecycleScope.launch {
                    delay(200)
                    binding.layoutPlayerScreen.transitionToStart()
                }
            }
        }
    }
}