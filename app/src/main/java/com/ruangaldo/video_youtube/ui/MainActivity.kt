package com.ruangaldo.video_youtube.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ruangaldo.video_youtube.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ruangaldo.video_youtube.R
import com.ruangaldo.video_youtube.databinding.ActivityMainBinding
import com.ruangaldo.video_youtube.model.MessageEvent
import com.ruangaldo.video_youtube.model.MessageHideEvent
import com.ruangaldo.video_youtube.utils.gone
import com.ruangaldo.video_youtube.utils.invisible
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity<ActivityMainBinding>(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var _navController: NavController? = null

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onTetopiMessageEvent(event: MessageEvent) {
        if (event.message == "run") {
            supportFragmentManager.beginTransaction()
                .replace(R.id.play_screen_frame_layout, PlayerScreen())
                .addToBackStack(null) // used to enable popBackStack().
                .commitAllowingStateLoss()
            Log.e("Tes","Asek iso ${event.message}")
        }

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHide(event: MessageHideEvent) {
        if (event.data == "hide") {
            binding.navView.invisible()
            Log.e("Tes","Asek iso ${event.data}")
        }

    }

    override fun setup() {
        _navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        binding.navView.setOnNavigationItemSelectedListener(this)


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