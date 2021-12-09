package com.example.practical_10

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import com.example.practical_10.Login.Companion.city
import com.example.practical_10.Login.Companion.email
import com.example.practical_10.Login.Companion.fullname
import com.example.practical_10.Login.Companion.phone
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.text.SimpleDateFormat
import java.util.*


class MainActivity2d : AppCompatActivity() {
    lateinit var set_alarm:TextView
    lateinit var guni: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2d)

        getSupportActionBar()?.hide()
        setStatusBarTransparent()
        set_alarm=findViewById(R.id.setalarm)


        var bottomnavview = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //bottomnavview.selectedItemId = R.id.bottomNavigationView
        bottomnavview.selectedItemId=R.id.bottomNavigationView

        bottomnavview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.notes -> {
                    Intent(this, NotesActivity::class.java).apply {
                        startActivity(this)
                    }
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Intent(this, MainActivity2d::class.java).apply {
                        startActivity(this)
                    }
                    return@setOnItemSelectedListener true

                }
            }
        }

        val dashboardlogout = findViewById<TextView>(R.id.textView8)
        dashboardlogout.setOnClickListener {
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
        }


        val imgview=findViewById<ImageView>(R.id.imagebyimage)
        imgview.setBackgroundResource(R.drawable.image_animation)
        guni = imgview.background as AnimationDrawable
        guni.start()

        val img1view=findViewById<ImageView>(R.id.vectorphoto)
        img1view.setBackgroundResource(R.drawable.heart)
        guni = img1view.background as AnimationDrawable
        guni.start()


        val fullname_dashboard=findViewById<TextView>(R.id.name_dashboard1)
        val phone_dashboard=findViewById<TextView>(R.id.phone_dashboard1)
        val city_dashboard=findViewById<TextView>(R.id.city_dashboard1)
        val email_dashboard=findViewById<TextView>(R.id.email_dashboard1)
        val email_dashboard_main=findViewById<TextView>(R.id.email_dashboard_main1)
        val name_dashboard_main=findViewById<TextView>(R.id.name_dashboard_main1)

        val tclock=findViewById<TextClock>(R.id.textclock)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tclock.format24Hour=null
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tclock.format12Hour="hh:mm:ss a MMM,dd yyyy"
        }

        name_dashboard_main.setText(fullname)
        email_dashboard_main.setText(email)
        fullname_dashboard.setText(fullname)
        phone_dashboard.setText(phone)
        city_dashboard.setText(city)
        email_dashboard.setText(email)




        set_alarm.setOnClickListener {
            showTimerDialog()
        }

    }

    fun showTimerDialog()
    {
        val cldr: Calendar = Calendar.getInstance()
        val hour: Int = cldr.get(Calendar.HOUR_OF_DAY)
        val minutes: Int = cldr.get(Calendar.MINUTE)
// time picker dialog
        val picker = TimePickerDialog(
            this,
            { tp, sHour, sMinute -> sendDialogDataToActivity(sHour, sMinute) },
            hour,
            minutes,
            false
        )
        picker.show()
    }

    private fun sendDialogDataToActivity(hour: Int, minute: Int) {
        val alarmCalendar = Calendar.getInstance()
        val year: Int = alarmCalendar.get(Calendar.YEAR)
        val month: Int = alarmCalendar.get(Calendar.MONTH)
        val day: Int = alarmCalendar.get(Calendar.DATE)
        alarmCalendar.set(year, month, day, hour, minute, 0)
        set_alarm.text = SimpleDateFormat("hh:mm ss a").format(alarmCalendar.time)
        setAlarm(alarmCalendar.timeInMillis, "Start")
        Toast.makeText(
            this,
            "Time: hours:${hour}, minutes:${minute}, millis:${alarmCalendar.timeInMillis}",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun setAlarm(millisTime: Long, str: String)
    {
        val intent = Intent(this, AlarmBroadcastReceiver::class.java)
        intent.putExtra("Service1", str)
        val pendingIntent = PendingIntent.getBroadcast(applicationContext, 234324243, intent, 0)
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        if(str == "Start") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, millisTime, pendingIntent)
            }
        }else if(str == "Stop")
        {
            alarmManager.cancel(pendingIntent)
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

    private fun setWindowFlag(bits: Int, on: Boolean){
        val winParameters=window.attributes
        if(on) {
            winParameters.flags = winParameters.flags or bits
        }else{
            winParameters.flags=winParameters.flags and bits.inv()
        }
        window.attributes=winParameters
    }
}