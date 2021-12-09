package com.example.practical_9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        /*
        val txt1 : TextView = findViewById(R.id.textView6)

        txt1.setOnClickListener{
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

         */

        val login : Button=findViewById(R.id.button2)
        val log1=findViewById<TextView>(R.id.textView6)
        val fullname_signup : EditText=findViewById(R.id.editTextTextPersonName2)
        val phone_signup=findViewById<EditText>(R.id.editTextPhone)
        val email_signup=findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val city_signup=findViewById<EditText>(R.id.editTextTextPersonName3)
        val password_signup=findViewById<EditText>(R.id.editTextTextPassword2)
        val confirm_pass_signup=findViewById<EditText>(R.id.editTextTextPassword3)

        log1.setOnClickListener {
            Intent(this, MainActivity::class.java).apply { startActivity(this) }
        }

        login.setOnClickListener {

            LoginInfo.fullname = fullname_signup.text.toString()
            LoginInfo.phone = phone_signup.text.toString()
            LoginInfo.email = email_signup.text.toString()
            LoginInfo.city = city_signup.text.toString()
            LoginInfo.password = password_signup.text.toString()
            LoginInfo.confirm_pass = confirm_pass_signup.text.toString()

            if (LoginInfo.password == LoginInfo.confirm_pass) {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                }
            } else {

                Toast.makeText(
                    applicationContext, "Password and Confirm Password does not match",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

    }
}
