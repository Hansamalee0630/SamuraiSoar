package com.example.samuraisoarbladerunner

import android.graphics.Canvas

class GameEngine {
    var backgroundImage: BackgroundImage
    var samurai: Samurai

    init {
        backgroundImage = BackgroundImage()
        samurai = Samurai()
        // 0 - Not started, 1 - Playing, 2 - Game over
        gameState = 0
    }

    fun updateAndDrawBackgroundImage(canvas: Canvas) {
        AppConstants.bitmapBank?.let { bitmapBank ->
            backgroundImage.x = backgroundImage.x - backgroundImage.velocity
            if (backgroundImage.x < -bitmapBank.backgroundWidth) {
                backgroundImage.x = 0
            }
            canvas.drawBitmap(
                bitmapBank.background,
                backgroundImage.x.toFloat(),
                backgroundImage.y.toFloat(),
                null
            )
            if (backgroundImage.x < -(bitmapBank.backgroundWidth - AppConstants.SCREEN_WIDTH)) {
                canvas.drawBitmap(
                    bitmapBank.background,
                    (backgroundImage.x + bitmapBank.backgroundWidth).toFloat(),
                    backgroundImage.y.toFloat(),
                    null
                )
            }
        }
    }


    fun updateAndDrawSamurai(canvas: Canvas) {
        AppConstants.bitmapBank?.let { bitmapBank ->
            if (gameState == 1) {
                if (samurai.y < AppConstants.SCREEN_HEIGHT - bitmapBank.backgroundHeight || samurai.velocity < 0) {
                    samurai.velocity = samurai.velocity + AppConstants.gravity
                    samurai.y = samurai.y + samurai.velocity
                    samurai.updatePhysics()
                }
            }
            var currentFrame = samurai.currentFrame
            canvas.drawBitmap(
                bitmapBank.getSamurai(currentFrame),
                samurai.x.toFloat(),
                samurai.y.toFloat(),
                null
            )
            currentFrame++

            // If it extends max frame re-initialize to 0
            if (currentFrame > Samurai.maxFrame) {
                currentFrame = 0
            }
            samurai.currentFrame = currentFrame
        }
    }


    companion object {
        var gameState: Int = 0
    }
}