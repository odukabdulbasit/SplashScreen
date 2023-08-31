package com.odukabdulbasit.splashscreen


import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout for the splash screen
        setContentView(R.layout.activity_splash)

        // Optional: You can perform any initialization tasks here
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        // Create a translation animation
        val translateAnimation = TranslateAnimation(0f, 0f, 0f, -100f)
        translateAnimation.duration = 1000 // 1 second

        // Create a rotation animation
        val rotateAnimation = RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 1000 // 1 second

        // Create a fade-out animation
        val fadeOutAnimation = AlphaAnimation(1f, 0f)
        fadeOutAnimation.duration = 1000 // 1 second

        // Combine animations into an AnimationSet
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(translateAnimation)
        animationSet.addAnimation(rotateAnimation)
        animationSet.addAnimation(fadeOutAnimation)

        // Apply animation to the TextView
        welcomeTextView.startAnimation(animationSet)



        // Create a delay using a Handler to transition to the main activity after a certain time
        val handler = android.os.Handler()
        handler.postDelayed({
            // Start the main activity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Close the splash activity
            finish()
        }, SPLASH_DELAY) // Set the delay time in milliseconds
    }

    companion object {
        private const val SPLASH_DELAY: Long = 3000 // 3 seconds
    }
}