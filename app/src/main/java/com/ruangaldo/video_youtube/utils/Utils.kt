package com.ruangaldo.video_youtube.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * View visibility
 */
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

/**
 * Image configuration
 */
fun ImageView.cacheImage(path: String?) {
    Glide.with(this.context)
        .load(path)
        .transition(DrawableTransitionOptions.withCrossFade(200))
        .into(this)
}

