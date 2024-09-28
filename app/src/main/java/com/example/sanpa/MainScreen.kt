package com.example.sanpa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sanpa.databinding.ActivityMainScreenBinding // Import the binding class

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding // Declare the binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflate the layout using View Binding
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listeners
        binding.loginButton.setOnClickListener {
            // Navigate to the Sign In Activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close MainScreen if needed
        }

        binding.signupButton.setOnClickListener {
            // Navigate to the Dashboard
            val intent = Intent(this, DashBoard::class.java)
            startActivity(intent)
            finish() // Close MainScreen if needed
        }

        binding.textView.setOnClickListener {
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
