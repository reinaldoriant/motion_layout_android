package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.base.BaseFragment
import com.ruangaldo.video_youtube.databinding.FragmentFirstBinding
import com.ruangaldo.video_youtube.utils.DataDummy

class FirstFragment : BaseFragment<FragmentFirstBinding>() {
    // Get one data dummy
    private var _dataDummy = DataDummy.generateAudioArticleListDummy().first()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding
        get() = FragmentFirstBinding::inflate

    override fun setup() {
//        binding.topImage.cacheImage(this._dataDummy.thumbnail)

//        binding.button.setOnClickListener {
//            binding.layoutTtsPlayed.visible()
//
//            val mBundle = Bundle()
//            mBundle.putParcelable(EXTRA_ARTICLE, _dataDummy)
//
//            val playerScreenFragment = PlayerScreen()
//            playerScreenFragment.arguments = mBundle

        val firstPageFirstFragment = FirstPageFirstFragment()

            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, firstPageFirstFragment)
                .commitAllowingStateLoss()

//        }
//        binding.button2.setOnClickListener {
//            Toast.makeText(requireContext(),"Hi",Toast.LENGTH_SHORT).show()
//            Log.e("Hi","Muncul ga aku?")
//        }
    }

}