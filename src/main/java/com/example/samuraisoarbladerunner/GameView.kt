package com.example.samuraisoarbladerunner

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {
    private var gameThread: GameThread? = null

    init {
        initView()
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        if (gameThread == null || !gameThread!!.isRunning) {
            gameThread = GameThread(holder)
            gameThread!!.start()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Handle surface changes if needed
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        if (gameThread != null && gameThread!!.isRunning) {
            gameThread!!.isRunning = false
            try {
                gameThread!!.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    private fun initView() {
        val holder = holder
        holder.addCallback(this)
        isFocusable = true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val action = event!!.actionMasked
        val gameEngine = AppConstants.gameEngine // Store gameEngine in a local variable
        Log.d("GameView", "onTouchEvent called")
        if (action == MotionEvent.ACTION_DOWN && gameEngine != null) {
            // Make the Samurai jump
            gameEngine.samurai.jump()
            performClick() // Call performClick when a click action occurs
            return true
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        // Handle the click event here, if necessary
        return true
    }
}

