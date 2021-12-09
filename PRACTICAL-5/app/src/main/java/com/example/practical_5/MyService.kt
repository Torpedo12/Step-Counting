package com.example.practical_5

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class MyService : Service() {
    lateinit var mediaplayer:MediaPlayer
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaplayer.isInitialized){
            mediaplayer = MediaPlayer.create(this,R.raw.mucis)
        }

        val string1:String? = intent!!.getStringExtra("Service1")

        if (string1 == "Play")
        {
            mediaplayer.start()
        }
        else if (string1 == "Pause")
        {
            mediaplayer.pause()
        }
        return START_STICKY
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        mediaplayer.stop()
        super.onDestroy()
    }
}


