package com.ruangaldo.video_youtube.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvayonara.mealsfood.core.base.BaseFragment
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.databinding.FragmentFirstBinding
import com.ruangaldo.video_youtube.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSecondBinding
        get() = FragmentSecondBinding::inflate

    override fun setup() {

    }
}