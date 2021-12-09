package com.example.practical_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1:Button=findViewById(R.id.button)
        val tv1:TextView=findViewById(R.id.textView)
    }

    fun changeText(view: android.view.View) {
        Toast.makeText(this,"Button is Clickes",Toast.LENGTH_LONG ).show()

    }
}