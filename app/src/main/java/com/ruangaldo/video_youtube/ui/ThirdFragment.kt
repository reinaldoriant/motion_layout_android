package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment<FragmentThirdBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentThirdBinding
        get() = FragmentThirdBinding::inflate

    override fun setup() {

    }
}