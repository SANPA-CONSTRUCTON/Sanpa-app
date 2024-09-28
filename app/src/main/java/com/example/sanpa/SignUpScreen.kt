package com.example.sanpa

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sanpa.databinding.ActivitySignUpScreenBinding // Ensure this matches your XML file name
import com.google.firebase.auth.FirebaseAuth

class SignUpScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpScreenBinding // Use the correct binding class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        binding.submitButton.setOnClickListener { // Use the ID from your XML
            val username = binding.name.text.toString().trim() // Updated ID for name field
            val email = binding.email.text.toString().trim() // Updated ID for email field
            val password = binding.password.text.toString().trim() // Updated ID for password field
            val confirmPassword = binding.rePassword.text.toString().trim() // Updated ID for re-password field

            // Validate input fields
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showToast("Please fill in all fields")
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                showToast("Passwords do not match")
                return@setOnClickListener
            }

            // Firebase Sign-Up
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        showToast("Sign-up successful")
                    } else {
                        showToast(task.exception?.localizedMessage ?: "Sign-up failed")
                    }
                }
        }


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
