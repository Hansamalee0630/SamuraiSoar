package com.example.samuraisoarbladerunner

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object AppConstants {
    // Return bitmapBank instance
    var bitmapBank: BitmapBank? = null //Bitmap object reference

    // Return GameEngine instance
    var gameEngine: GameEngine? = null //GameEngine object reference
    var SCREEN_WIDTH = 0
    var SCREEN_HEIGHT = 0
    var gravity = 0
    var VELOCITY_WHEN_JUMPED = 0
    val GROUND_LEVEL = SCREEN_HEIGHT - 100
    const val GRAVITY = 0.5f
    fun initialization(context: Context) {
        setScreenSize(context)
        bitmapBank = BitmapBank(context.resources)
        gameEngine = GameEngine()
        gravity = 3
        VELOCITY_WHEN_JUMPED = -20
    }

    private fun setScreenSize(context: Context) {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)
        val width = metrics.widthPixels
        val height = metrics.heightPixels
        SCREEN_WIDTH = width
        SCREEN_HEIGHT = height
    }
}
