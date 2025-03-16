package com.eddyjyliu.videoedit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import com.eddyjyliu.videoedit.controller.MediaController

class PreviewActivity : AppCompatActivity() {

    lateinit var previewSurface: SurfaceView
    val mediaController by lazy { MediaController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        previewSurface = findViewById(R.id.preview)
    }
}