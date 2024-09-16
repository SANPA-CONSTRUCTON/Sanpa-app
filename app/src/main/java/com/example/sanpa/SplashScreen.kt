package com.example.sanpa

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        // Delay for 2 seconds before checking authentication status
        Handler(Looper.getMainLooper()).postDelayed({
            checkUserStatus()
        }, 2000) // 2 seconds delay
    }

    // Check if the user is logged in or not
    private fun checkUserStatus() {
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // If user is logged in, redirect to MainActivity
            startActivity(Intent(this@SplashScreen, MainScreen::class.java))
        } else {
            // If user is not logged in, redirect to LoginActivity
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
        }
        // Finish SplashScreen activity so it is not part of the back stack
        finish()
    }
}
