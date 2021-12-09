package com.example.practical_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_play:Button = findViewById(R.id.button2)
        val btn_pause:Button = findViewById(R.id.button)
        val btn_stop:Button = findViewById(R.id.button3)

        btn_play.setOnClickListener{
            var intent:Intent = Intent(applicationContext,MyService::class.java)
            intent.putExtra("Service1","Play")
            startService(intent)
        }

        btn_pause.setOnClickListener{
            var intent:Intent = Intent(applicationContext,MyService::class.java)
            intent.putExtra("Service1","Pause")
            startService(intent)
        }

        btn_stop.setOnClickListener{
            var intent:Intent = Intent(applicationContext,MyService::class.java)
            stopService(intent)
        }
    }
}
