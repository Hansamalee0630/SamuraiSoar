package com.example.samuraisoarbladerunner

import android.graphics.Canvas
import android.util.Log

class Samurai {
    // Setter methods for x and y coordinates
    // Getter methods for x and y coordinates
    @JvmField
    var x: Int = 0

    @JvmField
    var y: Int = 0

    // Getter and setter methods for current frame
    @JvmField
    var currentFrame: Int

    // Getter and setter methods for velocity
    @JvmField
    var velocity: Int

    init {
        AppConstants.bitmapBank?.let { bitmapBank ->
            val samuraiWidth = bitmapBank.samuraiWidth
            val samuraiHeight = bitmapBank.samuraiHeight
            x = AppConstants.SCREEN_WIDTH / 2 - samuraiWidth / 2
            y = AppConstants.SCREEN_HEIGHT / 2 - samuraiHeight / 2
        }
        currentFrame = 0
        maxFrame = 3 // Adjust if you have more frames
        velocity = 0
    }


    fun jump() {
        if (y >= AppConstants.GROUND_LEVEL) {
            Log.d("Samurai", "Jumping from: $y") // Make sure samurai jumps only if on the ground
            velocity =
                AppConstants.VELOCITY_WHEN_JUMPED // This should be a negative value to move up
        }
    }

    fun updatePhysics() {
        velocity = (velocity + AppConstants.GRAVITY).toInt()
        y += velocity
        Log.d("Samurai", "Updated Y: $y Velocity: $velocity")
        if (y > AppConstants.GROUND_LEVEL) {
            y = AppConstants.GROUND_LEVEL
            velocity = 0
        }
    }

    fun draw(canvas: Canvas) {
        AppConstants.bitmapBank?.let { bitmapBank ->
            val currentFrame = currentFrame
            canvas.drawBitmap(
                bitmapBank.getSamurai(currentFrame),
                x.toFloat(),
                y.toFloat(),
                null
            )
            incrementFrame()
        }
    }


    fun incrementFrame() {
        currentFrame = (currentFrame + 1) % maxFrame
        currentFrame = currentFrame
    }

    companion object {
        @JvmField
        var maxFrame: Int = 0
    }
}
