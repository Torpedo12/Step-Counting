package com.example.practical_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Relative_layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val bot = findViewById<BottomNavigationView>(R.id.bottomNavigationView3)
        bot.setOnItemReselectedListener{
            when(it.itemId){
                R.id.linear->{
                    val intent= Intent(this,Linear_Layout::class.java)
                    startActivity(intent)
                }
                R.id.constraint->{
                    val intent=
                        Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}