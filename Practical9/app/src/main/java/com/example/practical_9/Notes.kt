package com.example.practical_9

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class Notes (
    var title: String, var subTitle: String, var description: String, var modifiedTime: Calendar,
    var isReminder: Boolean = false
) {
    var timeStamp: Long = System.currentTimeMillis()
    var id = noteIdGeneration()

    companion object {
        var idNote = 0
        fun noteIdGeneration(): Int {
            idNote++
            return idNote
        }

        var notesArray: List<Notes> = ArrayList()

        fun setReminder(context: Context, notes: Notes) {

            val index = notesArray.indexOf(notes)
            val intent = Intent(context, NotificationReceiver::class.java)
            intent.putExtra("index", index)

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                index,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val alarmManager =
                context.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager

            if (notes.isReminder) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        notes.modifiedTime.timeInMillis,
                        pendingIntent
                    )
                }
            } else
                alarmManager.cancel(pendingIntent)
        }
    }
}
