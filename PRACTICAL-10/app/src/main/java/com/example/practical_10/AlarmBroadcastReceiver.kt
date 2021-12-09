package com.example.practical_10

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class AlarmBroadcastReceiver : BroadcastReceiver() {

    var mp: MediaPlayer? = null

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.


        if(intent != null)
        {
            mp = MediaPlayer.create(context, R.raw.alarm);
            mp?.start()
        }

    }
}
