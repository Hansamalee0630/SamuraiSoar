package com.example.samuraisoarbladerunner

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Tree(context: Context, private var x: Int, private val y: Int) {
    private val image: Bitmap
    private val speed = 5

    init {
        image = BitmapFactory.decodeResource(context.resources, R.drawable.tree1)
    }

    fun update() {
        // Move the tree to the left
        x -= speed
        if (x < -image.getWidth()) {
            // Reset the tree to the far right once it goes off the screen to the left
            x = AppConstants.SCREEN_WIDTH
        }
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }
}
