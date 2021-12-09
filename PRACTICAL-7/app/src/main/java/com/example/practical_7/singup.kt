package com.example.practical_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class singup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)

        val login : Button=findViewById(R.id.button2)
        val log1=findViewById<TextView>(R.id.textView6)
        val fullname_signup :

                EditText=findViewById(R.id.editTextTextPersonName2)

        val phone_signup=findViewById<EditText>(R.id.editTextPhone)

        val email_signup=findViewById<EditText>(R.id.editTextTextEmailAddress2)

        val city_signup=findViewById<EditText>(R.id.editTextTextPersonName3)

        val password_signup=findViewById<EditText>(R.id.editTextTextPassword2)

        val confirm_pass_signup=findViewById<EditText>(R.id.editTextTextPassword3)

        log1.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this) }
        }
        login.setOnClickListener {
            loginInfo.fullname = fullname_signup.text.toString()
            loginInfo.phone = phone_signup.text.toString()
            loginInfo.email = email_signup.text.toString()
            loginInfo.city = city_signup.text.toString()
            loginInfo.password = password_signup.text.toString()
            loginInfo.confirm_pass =
                confirm_pass_signup.text.toString()
            if (loginInfo.password == loginInfo.confirm_pass) {
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
