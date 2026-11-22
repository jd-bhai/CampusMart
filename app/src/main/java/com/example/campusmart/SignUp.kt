package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        var passwordVisible = false

        findViewById<ImageView>(R.id.ivTogglePassword).setOnClickListener {
            passwordVisible = !passwordVisible
            etPassword.inputType = passwordInputType(passwordVisible)
            etPassword.setSelection(etPassword.text.length)
        }

        findViewById<ImageView>(R.id.ivToggleConfirmPassword).setOnClickListener {
            passwordVisible = !passwordVisible
            etConfirmPassword.inputType = passwordInputType(passwordVisible)
            etConfirmPassword.setSelection(etConfirmPassword.text.length)
        }

        findViewById<ImageView>(R.id.ivBack).setOnClickListener { finish() }

        findViewById<android.view.View>(R.id.btnCreateAccount).setOnClickListener {
            startActivity(Intent(this, CreateProfile::class.java))
            finish()
        }

        findViewById<TextView>(R.id.tvSignIn).setOnClickListener { finish() }
    }

    private fun passwordInputType(visible: Boolean): Int {
        return if (visible) {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        } else {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    }
}
