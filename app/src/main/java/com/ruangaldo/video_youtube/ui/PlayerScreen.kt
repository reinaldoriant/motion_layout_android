package com.ruangaldo.video_youtube.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.lifecycleScope
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentPlayerScreenBinding
import com.ruangaldo.video_youtube.model.Article
import com.ruangaldo.video_youtube.model.MessageEvent
import com.ruangaldo.video_youtube.model.MessageHideEvent
import com.ruangaldo.video_youtube.utils.cacheImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus


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
                initPlaylist()

                // Call transition to start (minimize) programatically.
                lifecycleScope.launch {
                    delay(200)
                    binding.layoutPlayerScreen.transitionToStart()
                }
            }

            /**
             * Execute popBackStack() when swipe to dismiss PlayScreen fragment (drag down)
             * References: https://proandroiddev.com/building-swipeview-using-motionlayout-7a80fd06401c
             */
            binding.layoutPlayerScreen.addTransitionListener(object :
                MotionLayout.TransitionListener {
                override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                }

                override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                }

                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                    if (p1 == R.id.screen_close) {
                        // Call popBackStack() to exit PlayerScreen fragment.
                        parentFragmentManager.popBackStack()
                        Toast.makeText(requireActivity(),
                            "player screen closed.",
                            Toast.LENGTH_LONG).show()
                        val newMessageToSend = MessageHideEvent("hide")
                        EventBus.getDefault().post(newMessageToSend)
                    } else if (p1 == R.id.screen_normal) {
                        val newMessageToSend = MessageHideEvent("hide")
                        EventBus.getDefault().post(newMessageToSend)
                    }
                }

                override fun onTransitionTrigger(
                    p0: MotionLayout?,
                    p1: Int,
                    p2: Boolean,
                    p3: Float,
                ) {
                }
            })
        }
    }

    private fun initPlaylist() {
        childFragmentManager.beginTransaction()
            .replace(R.id.play_screen_frame_layout, AudioArticlesFragment())
            .addToBackStack(null)
            .commit()
    }

    fun exitPlaylist() {
        // Call transition to end (maximize) programatically
        lifecycleScope.launch {
            delay(200)
            binding.layoutPlayerScreen.transitionToEnd()
        }
    }

    /**
     * Used to check is PlayerScreen destroyed when exit this fragment using popBackStack().
     */
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("check if destroyed", "true")
    }
}