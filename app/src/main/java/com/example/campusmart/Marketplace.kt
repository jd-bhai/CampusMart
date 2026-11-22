package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Marketplace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_marketplace)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<View>(R.id.layoutSearch).setOnClickListener { open(Search::class.java) }
        findViewById<View>(R.id.tabBorrow).setOnClickListener { open(BorrowLend::class.java) }

        val itemIds = listOf(
            R.id.cardItem1, R.id.cardItem2, R.id.cardItem3, R.id.cardItem4,
            R.id.cardItem5, R.id.cardItem6, R.id.cardItem7, R.id.cardItem8
        )
        itemIds.forEach { id ->
            findViewById<View>(id).setOnClickListener { open(ItemDetails::class.java) }
        }

        wireBottomNav()
    }

    private fun wireBottomNav() {
        findViewById<View>(R.id.navHome).setOnClickListener { open(Home::class.java) }
        findViewById<View>(R.id.navSell).setOnClickListener { open(ListItem::class.java) }
        findViewById<View>(R.id.navChat).setOnClickListener { open(Chats::class.java) }
        findViewById<View>(R.id.navProfile).setOnClickListener { open(MyProfile::class.java) }
    }

    private fun open(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
