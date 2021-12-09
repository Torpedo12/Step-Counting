package com.example.practical_9

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.practical_9.LoginInfo.Companion.email
import com.example.practical_9.LoginInfo.Companion.password

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login_button=findViewById<Button>(R.id.button3)//problem
        val signup_text=findViewById<TextView>(R.id.textView7)
        val email_login=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password_login=findViewById<EditText>(R.id.editTextTextPassword)
        val btn1 : Button = findViewById(R.id.button)

        signup_text.setOnClickListener{
            Intent(this,signup::class.java).apply {
                startActivity(this)
            }
        }
        btn1.setOnClickListener{
            Intent(this,signup::class.java).apply {
                startActivity(this)
            }
        }
        login_button.setOnClickListener{

            var email_input=email_login.text.toString()
            var password_input=password_login.text.toString()

            if(email_input == email && password_input == password.toString() )
            {
                Intent(this,dashboard::class.java).apply {
                    startActivity(this)
                }
            }
            else{
                Toast.makeText(applicationContext,"Enter valid email or password",Toast.LENGTH_LONG).show()
            }
        }
    }

}
