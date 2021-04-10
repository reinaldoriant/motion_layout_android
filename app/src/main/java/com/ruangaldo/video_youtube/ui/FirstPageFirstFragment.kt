package com.ruangaldo.video_youtube.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentFirstPageBinding
import com.ruangaldo.video_youtube.ui.PlayerScreen.Companion.EXTRA_ARTICLE
import com.ruangaldo.video_youtube.utils.DataDummy
import com.ruangaldo.video_youtube.utils.cacheImage
import com.ruangaldo.video_youtube.utils.visible

class FirstPageFirstFragment : BaseFragment<FragmentFirstPageBinding>() {
    // Get one data dummy
    private var _dataDummy = DataDummy.generateAudioArticleListDummy().first()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstPageBinding
        get() = FragmentFirstPageBinding::inflate

    override fun setup() {
        binding.topImage.cacheImage(this._dataDummy.thumbnail)

        binding.button.setOnClickListener {
            binding.layoutTtsPlayed.visible()

            val mBundle = Bundle()
            mBundle.putParcelable(EXTRA_ARTICLE, _dataDummy)

            val playerScreenFragment = PlayerScreen()
            playerScreenFragment.arguments = mBundle

            childFragmentManager.beginTransaction()
                .replace(R.id.play_screen_frame_layout, playerScreenFragment)
                .commitAllowingStateLoss()
        }

        binding.button2.setOnClickListener {
            Toast.makeText(requireContext(), "Hi", Toast.LENGTH_SHORT).show()
            Log.e("Hi", "Muncul ga aku?")
        }
    }
}