package com.example.campusmart

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<View>(R.id.layoutSearch).setOnClickListener { open(Search::class.java) }
        findViewById<View>(R.id.tvSeeBuySell).setOnClickListener { open(BuySell::class.java) }
        findViewById<View>(R.id.tvSeeBorrowLend).setOnClickListener { open(BorrowLend::class.java) }

        findViewById<View>(R.id.cardBuy).setOnClickListener { open(BuySell::class.java) }
        findViewById<View>(R.id.cardSell).setOnClickListener { open(ListItem::class.java) }
        findViewById<View>(R.id.cardBorrow).setOnClickListener { open(BorrowLend::class.java) }
        findViewById<View>(R.id.cardLend).setOnClickListener { open(ListItem::class.java) }

        findViewById<View>(R.id.cardBuySell1).setOnClickListener { open(ItemDetails::class.java) }
        findViewById<View>(R.id.cardBuySell2).setOnClickListener { open(ItemDetails::class.java) }
        findViewById<View>(R.id.cardBorrowLend1).setOnClickListener { open(ItemDetails::class.java) }
        findViewById<View>(R.id.cardBorrowLend2).setOnClickListener { open(ItemDetails::class.java) }

        findViewById<View>(R.id.navMarket).setOnClickListener { open(Marketplace::class.java) }
        findViewById<View>(R.id.navSell).setOnClickListener { open(ListItem::class.java) }
        findViewById<View>(R.id.navChat).setOnClickListener { open(Chats::class.java) }
        findViewById<View>(R.id.navProfile).setOnClickListener { open(MyProfile::class.java) }
    }

    private fun open(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
