package com.ruangaldo.video_youtube.ui

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.ruangaldo.video_youtube.R

class PlayerScreenMotionLayout(context: Context,attributeSet: AttributeSet?=null):MotionLayout(context,attributeSet) {

    private val viewToDetectTouch by lazy {
        findViewById<View>(R.id.bg_player_scene)
    }
    private val viewRect = Rect()
    private var hasTouchStarted = false
    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            transitionToEnd()
            return false
        }
    })

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)   //This ensures the Mini Player is maximised on single tap
        when (event.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                hasTouchStarted = false
                return super.onTouchEvent(event)
            }
        }
        if (!hasTouchStarted) {
            viewToDetectTouch.getHitRect(viewRect)
            hasTouchStarted = viewRect.contains(event.x.toInt(), event.y.toInt())
        }
        return hasTouchStarted && super.onTouchEvent(event)
    }
}