package com.example.practical_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Linear_Layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        val bot =
            findViewById<BottomNavigationView>(R.id.bottomNavigationView1)
        bot.setOnItemReselectedListener{
            when(it.itemId){
                R.id.constraint->{
                    val intent=
                        Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.relative->{
                    val intent= Intent(this,Relative_layout::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}