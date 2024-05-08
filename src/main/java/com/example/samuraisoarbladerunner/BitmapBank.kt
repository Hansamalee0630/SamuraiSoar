package com.example.samuraisoarbladerunner

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class BitmapBank(res: Resources?) {
    //return background bitmap
    var background: Bitmap
    var samurai: Bitmap

    init {
        background = BitmapFactory.decodeResource(res, R.drawable.background_01)
        background = scaleImage(background)
        samurai = BitmapFactory.decodeResource(res, R.drawable.samurai)
        samurai = scaleSamurai(samurai) // Method to scale the samurai bitmap
    }

    //Return samurai bitmap of frame
    fun getSamurai(currentFrame: Int): Bitmap {
        return samurai
    }

    val samuraiWidth: Int
        get() = samurai.getWidth()
    val samuraiHeight: Int
        get() = samurai.getHeight()
    val backgroundWidth: Int
        //return background width
        get() = background.getWidth()
    val backgroundHeight: Int
        //return background height
        get() = background.getHeight()

    // Method to scale samurai bitmap
    private fun scaleSamurai(original: Bitmap): Bitmap {
        val height =
            (original.getHeight() * 0.5).toInt() // Scale down to 50% of the original height
        val width = (original.getWidth() * 0.5).toInt() // Scale down to 50% of the original width
        return Bitmap.createScaledBitmap(original, width, height, false)
    }

    fun scaleImage(bitmap: Bitmap?): Bitmap {
        val widthHeightRatio = backgroundWidth.toFloat() / backgroundHeight
        val backgroundScaledWidth = widthHeightRatio.toInt() * AppConstants.SCREEN_HEIGHT
        return Bitmap.createScaledBitmap(
            bitmap!!,
            backgroundScaledWidth,
            AppConstants.SCREEN_HEIGHT,
            false
        )
    }
}
