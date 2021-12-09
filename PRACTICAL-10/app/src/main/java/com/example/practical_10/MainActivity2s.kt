package com.example.practical_10

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practical_10.Login.Companion.city
import com.example.practical_10.Login.Companion.confirm_pass
import com.example.practical_10.Login.Companion.email
import com.example.practical_10.Login.Companion.fullname
import com.example.practical_10.Login.Companion.password
import com.example.practical_10.Login.Companion.phone


class MainActivity2s : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2s)

        setStatusBarTransparent()
        supportActionBar?.hide()

        val signUp=findViewById<Button>(R.id.button2)

        val log1=findViewById<TextView>(R.id.textView6)
        val fullname_signup : EditText =findViewById(R.id.editTextTextPersonName2)
        val phone_signup=findViewById<EditText>(R.id.editTextPhone)
        val email_signup=findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val city_signup=findViewById<EditText>(R.id.editTextTextPersonName3)
        val password_signup=findViewById<EditText>(R.id.editTextTextPassword2)
        val confirm_pass_signup=findViewById<EditText>(R.id.editTextTextPassword3)

        log1.setOnClickListener {
            Intent(this, MainActivity::class.java).apply { startActivity(this) }
        }
        signUp.setOnClickListener {

            fullname = fullname_signup.text.toString()
            phone = phone_signup.text.toString()
            email = email_signup.text.toString()
            city = city_signup.text.toString()
            password = password_signup.text.toString()
            confirm_pass = confirm_pass_signup.text.toString()

            if (password == confirm_pass) {
                Intent(this, MainActivity::class.java).apply {
                    startActivity(this)
                }
            } else {
                Toast.makeText(applicationContext,"Password and Confirm Password doesn't match",Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val winParameters = window.attributes
        if (on) {
            winParameters.flags = winParameters.flags or bits
        } else {
            winParameters.flags = winParameters.flags and bits.inv()
        }
        window.attributes = winParameters
    }

}

