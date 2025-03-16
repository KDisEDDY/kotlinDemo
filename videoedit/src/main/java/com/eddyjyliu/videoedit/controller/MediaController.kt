package com.eddyjyliu.videoedit.controller

import android.app.Application
import android.media.MediaPlayer
import android.net.Uri
import com.eddyjyliu.videoedit.base.BaseApplication

class MediaController {

    private val mediaPlayer = MediaPlayer()

    /**
     * key = url
     */
    val mediaDataMap = mutableMapOf<String, MediaData>()

    var currentMedia: MediaData? = null

    /**
     * 设置媒体数据
     */
    fun setData(mediaData: MediaData) {
        mediaDataMap[mediaData.uri.toString()] = mediaData
        currentMedia = mediaData
        mediaPlayer.setOnPreparedListener {

        }
        mediaPlayer.setOnCompletionListener {

        }
        mediaPlayer.setOnErrorListener { mp, what, extra ->

            true
        }
        startPlayer()
    }

    fun startPlayer() {
        currentMedia?.let {
            it.uri?.let {
                mediaPlayer.setDataSource(BaseApplication.myApplicationContext, it)
                mediaPlayer.prepare()
                mediaPlayer.start()
            } ?: return@let
        }
    }

    class MediaData {
        var uri : Uri? = null
        var url: String = ""
        var offset = 0L
    }
}