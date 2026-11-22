package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<View>(R.id.cardEditProfile).setOnClickListener { open(EditProfile::class.java) }
        findViewById<View>(R.id.cardMyListings).setOnClickListener { open(Marketplace::class.java) }
        findViewById<View>(R.id.cardSavedItems).setOnClickListener { open(Marketplace::class.java) }
        findViewById<View>(R.id.cardLogout).setOnClickListener {
            startActivity(
                Intent(this, Home::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            finish()
        }

        findViewById<View>(R.id.navHome).setOnClickListener { open(Home::class.java) }
        findViewById<View>(R.id.navMarket).setOnClickListener { open(Marketplace::class.java) }
        findViewById<View>(R.id.navSell).setOnClickListener { open(ListItem::class.java) }
        findViewById<View>(R.id.navChat).setOnClickListener { open(Chats::class.java) }
    }

    private fun open(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
