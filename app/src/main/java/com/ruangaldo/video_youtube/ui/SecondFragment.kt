package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSecondBinding
        get() = FragmentSecondBinding::inflate

    override fun setup() {

    }
}