package com.example.sanpa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordText: TextView
    private lateinit var googleLoginButton: ImageView
    private lateinit var facebookLoginButton: ImageView
    private lateinit var errorText: TextView
    private lateinit var signUpText: TextView  // Add this line

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Bind views
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        forgotPasswordText = findViewById(R.id.forgotPasswordText)
        googleLoginButton = findViewById(R.id.googleLoginButton)
        facebookLoginButton = findViewById(R.id.facebookLoginButton)
        errorText = findViewById(R.id.errorText)
        signUpText = findViewById(R.id.signUpText)  // Bind sign up text

        // Handle login button click
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                            // Navigate to the main activity or dashboard
                        } else {
                            errorText.text = task.exception?.localizedMessage ?: "Login failed"
                            errorText.visibility = TextView.VISIBLE
                        }
                    }
            } else {
                errorText.text = "Please enter both email and password"
                errorText.visibility = TextView.VISIBLE
            }
        }

        // Handle Forgot Password click
        forgotPasswordText.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Reset email sent", Toast.LENGTH_SHORT).show()
                        } else {
                            errorText.text = task.exception?.localizedMessage ?: "Failed to send reset email"
                            errorText.visibility = TextView.VISIBLE
                        }
                    }
            } else {
                errorText.text = "Please enter your email"
                errorText.visibility = TextView.VISIBLE
            }
        }

        // Handle Google and Facebook login buttons (add your own logic here)
        googleLoginButton.setOnClickListener {
            Toast.makeText(this, "Google login clicked", Toast.LENGTH_SHORT).show()
            // Implement Google login logic here
        }

        facebookLoginButton.setOnClickListener {
            Toast.makeText(this, "Facebook login clicked", Toast.LENGTH_SHORT).show()
            // Implement Facebook login logic here
        }

        // Handle Sign Up click
        signUpText.setOnClickListener {
            val intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
        }
    }
}
