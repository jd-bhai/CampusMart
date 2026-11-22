package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Chats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chats)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listOf(R.id.cardChat1, R.id.cardChat2, R.id.cardChat3, R.id.cardChat4, R.id.cardChat5)
            .forEach { id ->
                findViewById<View>(id).setOnClickListener { open(ChatDetail::class.java) }
            }

        findViewById<View>(R.id.navHome).setOnClickListener { open(Home::class.java) }
        findViewById<View>(R.id.navMarket).setOnClickListener { open(Marketplace::class.java) }
        findViewById<View>(R.id.navSell).setOnClickListener { open(ListItem::class.java) }
        findViewById<View>(R.id.navProfile).setOnClickListener { open(MyProfile::class.java) }
    }

    private fun open(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
