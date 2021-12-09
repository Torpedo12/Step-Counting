package com.example.practical_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bot = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bot.setOnItemReselectedListener{
            when(it.itemId){
                R.id.linear->{
                    val intent=Intent(this,Linear_Layout::class.java)
                    startActivity(intent)
                }
                R.id.relative->{
                    val intent=Intent(this,Relative_layout::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}



