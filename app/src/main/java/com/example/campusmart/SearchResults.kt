package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchResults : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etSearch = findViewById<EditText>(R.id.etSearch)

        findViewById<View>(R.id.ivBack).setOnClickListener { finish() }
        findViewById<View>(R.id.ivClear).setOnClickListener { etSearch.setText("") }

        listOf(R.id.btnChat1, R.id.btnChat2, R.id.btnChat3).forEach { id ->
            findViewById<View>(id).setOnClickListener {
                startActivity(Intent(this, ChatDetail::class.java))
            }
        }

        findViewById<View>(R.id.btnPostRequest).setOnClickListener {
            startActivity(Intent(this, ListItem::class.java))
        }
    }
}
