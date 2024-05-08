package com.example.samuraisoarbladerunner

import android.os.SystemClock
import android.util.Log
import android.view.SurfaceHolder

class GameThread(//Surface holder object reference
    var surfaceHolder: SurfaceHolder
) : Thread() {
    // Sets the thread state, false = stopped, true = running
    //Return whether the thread is running
    var isRunning = true
    var startTime: Long = 0
    var loopTime: Long = 0 //Loop start time and loop duration
    var DELAY: Long = 33 //Delay in milliseconds between screen refreshes
    override fun run() {
        super.run()

        while (isRunning) {
            startTime = SystemClock.uptimeMillis()
            val canvas = surfaceHolder.lockCanvas(null)
            if (canvas != null) {
                synchronized(surfaceHolder) {
                    AppConstants.gameEngine?.let { gameEngine ->
                        // Perform actions only if gameEngine is not null
                        gameEngine.updateAndDrawBackgroundImage(canvas)
                        gameEngine.updateAndDrawSamurai(canvas) // Draw Samurai here
                    }
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }

            loopTime = SystemClock.uptimeMillis() - startTime
            if (loopTime < DELAY) {
                try {
                    sleep(DELAY - loopTime)
                } catch (e: InterruptedException) {
                    Log.e("Interrupted", "Interrupted while starting")
                }
            }
        }
    }
}
