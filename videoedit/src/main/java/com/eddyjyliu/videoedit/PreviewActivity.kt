package com.eddyjyliu.videoedit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView

class PreviewActivity : AppCompatActivity() {

    lateinit var previewSurface: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        previewSurface = findViewById(R.id.preview)
    }
}