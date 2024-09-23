package com.example.sanpa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        // Initialize buttons and footer text
        val signInButton: Button = findViewById(R.id.signInButton)
        val dashboardButton: Button = findViewById(R.id.dashboardButton)
        val footerText: TextView = findViewById(R.id.footerText)

        // Set up click listeners
        signInButton.setOnClickListener {
            // Navigate to the Sign In Activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close MainScreen if needed
        }

        dashboardButton.setOnClickListener {
            // Navigate to the Dashboard
            val intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish() // Close MainScreen if needed
        }

        footerText.setOnClickListener {
            // Show terms and conditions dialog
            showTermsDialog()
        }
    }

    private fun showTermsDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Terms and Conditions")
            .setMessage("Please read and accept the terms and conditions before using the app.")
            .setPositiveButton("Agree") { dialog, _ ->
                Toast.makeText(this, "Thank you for agreeing!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}
