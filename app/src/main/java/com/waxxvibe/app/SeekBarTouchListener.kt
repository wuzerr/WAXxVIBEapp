package com.waxxvibe.app

import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar

class SeekBarTouchListener : View.OnTouchListener {
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        if (view is SeekBar) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Disable parent scroll view when slider interaction starts
                    view.parent?.requestDisallowInterceptTouchEvent(true)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Re-enable parent scroll view when slider interaction ends
                    view.parent?.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return false
    }
}
