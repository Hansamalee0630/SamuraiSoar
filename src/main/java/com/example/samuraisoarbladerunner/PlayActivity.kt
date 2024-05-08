package com.example.samuraisoarbladerunner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PlayActivity : AppCompatActivity() {
    private val BUTTON_DELAY = 6000L
    private lateinit var bottomAnim: Animation
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_play)
        AppConstants.initialization((this.applicationContext))

        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        startButton = findViewById(R.id.goButton)

        Handler().postDelayed({
            startButton.visibility = View.VISIBLE
            startButton.startAnimation(bottomAnim)
        }, BUTTON_DELAY)

        startButton.setOnClickListener {
            startGame()
        }
    }

    private fun startGame() {
        val intent = Intent(this, GameStart::class.java)
        startActivity(intent)
        finish()
    }
}
