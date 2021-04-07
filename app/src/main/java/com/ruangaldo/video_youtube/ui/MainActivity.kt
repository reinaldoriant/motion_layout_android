package com.ruangaldo.video_youtube.ui

import android.view.LayoutInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ruangaldo.video_youtube.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var _navController: NavController? = null

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setup() {
        _navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        binding.navView.setOnNavigationItemSelectedListener(this)
        binding.navView.selectedItemId = R.id.action_first_fragment
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_first_fragment -> _navController?.navigate(R.id.navigation_first)
            R.id.action_second_fragment -> _navController?.navigate(R.id.navigation_second)
            R.id.action_third_fragment -> _navController?.navigate(R.id.navigation_third)
        }
        return true
    }
}