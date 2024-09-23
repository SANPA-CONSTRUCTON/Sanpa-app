package com.example.sanpa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Initialize UI elements
        val usernameField = findViewById<EditText>(R.id.usernameField)
        val emailField = findViewById<EditText>(R.id.emailField)
        val passwordField = findViewById<EditText>(R.id.passwordField)
        val confirmPasswordField = findViewById<EditText>(R.id.confirmPasswordField)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val errorMessage = findViewById<TextView>(R.id.errorMessage)
        val googleSignIn = findViewById<ImageView>(R.id.googleSignIn)
        val facebookSignIn = findViewById<ImageView>(R.id.facebookSignIn)

        signUpButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            // Validate input fields
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                errorMessage.text = "Please fill in all fields"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                errorMessage.text = "Passwords do not match"
                return@setOnClickListener
            }

            // Firebase Sign-Up
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show()
                        errorMessage.text = ""
                    } else {
                        errorMessage.text = task.exception?.localizedMessage ?: "Sign-up failed"
                    }
                }
        }

        // Set click listeners for Google and Facebook sign-in
        googleSignIn.setOnClickListener {
            // Handle Google sign-up logic
            Toast.makeText(this, "Google Sign-In Clicked", Toast.LENGTH_SHORT).show()
        }

        facebookSignIn.setOnClickListener {
            // Handle Facebook sign-up logic
            Toast.makeText(this, "Facebook Sign-In Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
