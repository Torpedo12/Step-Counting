package com.example.practical_8

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.button)
        //yt
        val wv1:WebView = findViewById(R.id.webv)
        val websetting : WebSettings = wv1.settings
        websetting.javaScriptEnabled = true
        websetting.loadWithOverviewMode = true
        websetting.useWideViewPort = true
        wv1.loadUrl("https://www.youtube.com/embed/F63VHyyIE6U")
//video view
        btn.setOnClickListener {
            val vv1: VideoView = findViewById(R.id.vidv)
            //vv1.setOnClickListener {
            val mediaController = MediaController(this)
            mediaController.setAnchorView(vv1)
            val uri: Uri = Uri.parse("android.resource://" +
                    packageName + "/" + R.raw.video)
            vv1.setMediaController(mediaController)
            vv1.setVideoURI(uri)
            vv1.requestFocus()
            vv1.start()
            //}
        }
    }
}
