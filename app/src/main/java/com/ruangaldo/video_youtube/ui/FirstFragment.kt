package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruangaldo.video_youtube.PlayerScreen
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding>() {
    private var playScreenFragment = PlayerScreen.newInstance()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding
        get() = FragmentFirstBinding::inflate

    override fun setup() {
        binding.button.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.play_screen_frame_layout, playScreenFragment)
                .commitAllowingStateLoss()
        }
    }

}
