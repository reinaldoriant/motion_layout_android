package com.ruangaldo.video_youtube

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentPlayerScreenBinding


class PlayerScreen : BaseFragment<FragmentPlayerScreenBinding> (){
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlayerScreenBinding
        get() = FragmentPlayerScreenBinding::inflate

    override fun setup() {
    }
    companion object {
        const val TAG = "PlayScreenFragment"
        fun newInstance(): PlayerScreen {
            val args = Bundle()
            val playScreenFragment = PlayerScreen()
            playScreenFragment.arguments = args
            return playScreenFragment
        }
    }
}