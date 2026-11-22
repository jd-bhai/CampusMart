package com.example.campusmart

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListItem : AppCompatActivity() {
    private var sellSelected = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvSell = findViewById<TextView>(R.id.tvSell)
        val tvLend = findViewById<TextView>(R.id.tvLend)

        tvSell.setOnClickListener {
            sellSelected = true
            updateToggle(tvSell, tvLend)
        }
        tvLend.setOnClickListener {
            sellSelected = false
            updateToggle(tvSell, tvLend)
        }

        findViewById<View>(R.id.ivBack).setOnClickListener { finish() }
        findViewById<View>(R.id.btnPostItem).setOnClickListener { finish() }
    }

    private fun updateToggle(tvSell: TextView, tvLend: TextView) {
        tvSell.setBackgroundResource(if (sellSelected) R.drawable.bg_toggle_selected else 0)
        tvLend.setBackgroundResource(if (!sellSelected) R.drawable.bg_toggle_selected else 0)
        tvSell.setTextColor(if (sellSelected) Color.WHITE else Color.parseColor("#555555"))
        tvLend.setTextColor(if (!sellSelected) Color.WHITE else Color.parseColor("#555555"))
    }
}
