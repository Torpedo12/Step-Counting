package com.example.practical_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.practical_7.loginInfo.Companion.city
import com.example.practical_7.loginInfo.Companion.email
import com.example.practical_7.loginInfo.Companion.fullname
import com.example.practical_7.loginInfo.Companion.phone

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val fullname_dashboard=findViewById<TextView>(R.id.textView13)

        val phone_dashboard=findViewById<TextView>(R.id.textView15)

        val city_dashboard=findViewById<TextView>(R.id.textView19)

        val email_dashboard=findViewById<TextView>(R.id.textView17)

        val email_dashboard_main=findViewById<TextView>(R.id.textView9)

        val name_dashboard_main=findViewById<TextView>(R.id.textView8)

        name_dashboard_main.setText(fullname)
        email_dashboard_main.setText(email)
        fullname_dashboard.setText(fullname)
        phone_dashboard.setText(phone)
        city_dashboard.setText(city)
        email_dashboard.setText(email)

        val dashboardlogout =
            findViewById<TextView>(R.id.textView22)
        dashboardlogout.setOnClickListener {
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)

            }
        }
    }
}
