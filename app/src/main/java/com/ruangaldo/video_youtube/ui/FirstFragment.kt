package com.ruangaldo.video_youtube.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentFirstBinding
import com.ruangaldo.video_youtube.utils.visible

class FirstFragment : BaseFragment<FragmentFirstBinding>() {
    private var playScreenFragment = PlayerScreen.newInstance()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding
        get() = FragmentFirstBinding::inflate

    override fun setup() {
        binding.button.setOnClickListener {
            binding.layoutTtsPlayed.visible()

            childFragmentManager.beginTransaction()
                .replace(R.id.play_screen_frame_layout, playScreenFragment)
                .commitAllowingStateLoss()
        }
        binding.button2.setOnClickListener {
            Toast.makeText(requireContext(),"Hi",Toast.LENGTH_SHORT).show()
            Log.e("Hi","Muncul ga aku?")
        }
    }

}
