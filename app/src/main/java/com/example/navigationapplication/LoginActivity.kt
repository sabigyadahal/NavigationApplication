package com.example.NavigationApplication.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.NavigationApplication.ui.dashboard.DashboardActivity
import com.example.navigationapplication.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.loginButton)
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)

        loginViewModel.loginResult.observe(this) { keypass ->
            if (keypass != null) {
                // Navigate to DashboardActivity
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("keypass", keypass)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
