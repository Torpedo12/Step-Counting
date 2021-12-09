package com.example.practical_4

import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed1:EditText=findViewById((R.id.editText))
        val btn1:Button=findViewById(R.id.button)
        val btn2:Button=findViewById(R.id.button2)
        val btn3:Button=findViewById(R.id.button3)
        val btn4:Button=findViewById(R.id.button4)
        val btn5:Button=findViewById(R.id.button5)
        val btn6:Button=findViewById(R.id.button6)
        val btn7:Button=findViewById(R.id.button7)

        btn1.setOnClickListener{
            var str = ed1.text.toString()
            val callUri:Uri = Uri.parse("tel:$str")

            val intent:Intent = Intent(Intent.ACTION_DIAL,callUri)
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }else{
                Log.d("Implicit Intent","Dial Intent error")
            }
        }

        btn2.setOnClickListener{
            var str = ed1.text.toString()
            val webUri:Uri = Uri.parse(str)

            val intent:Intent = Intent(Intent.ACTION_VIEW,webUri)
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }else{
                Log.d("Implicit Intent","Web Intent error")
            }
        }

        btn3.setOnClickListener{
//var str = ed1.text.toString()
//val contactUri:Uri = Uri.parse(str)
/*
val intent:Intent = Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
if (intent.resolveActivity(packageManager)!=null){
    startActivity(intent)
}else{
    Log.d("Implicit Intent","Contact Intent error")
}
 */
            Intent(ACTION_PICK,ContactsContract.Contacts.CONTENT_URI).setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE).apply {
                startActivity(this)
            }
        }

        btn4.setOnClickListener{
            Intent(ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).apply {
                startActivity(this)
            }
        }

        btn5.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        btn6.setOnClickListener{

            Intent(Intent(AlarmClock.ACTION_SET_ALARM)).apply {
                startActivity(this)
            }
        }

        btn7.setOnClickListener{
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                startActivity(this)
            }
        }
    }
}







