package project.ljy.kotlindemo.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.annotation.OptIn
import androidx.constraintlayout.widget.ConstraintLayout
import com.eddyjyliu.baseutil.utils.ViewUtil
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.google.android.exoplayer2.ui.StyledPlayerView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseActivity

class VideoActivity: BaseActivity() {

    companion object {
        const val KEY_VIDEO_URL = "KEY_VIDEO_URL"

        fun gotoVideoActivity(context: Context, url: String) {
            context.startActivity(Intent(context, VideoActivity::class.java).apply {
                putExtra(KEY_VIDEO_URL, url)
            })
        }
    }

    @SuppressLint("RestrictedApi")
    private var exoPlayer: ExoPlayer? = null

    var originVideoUrl = ""
    var lastPlayState = 0
    var timeStamp = 0L

    override fun setSubContentView() = R.layout.activity_video

    override fun initOnCreateOperation(savedInstanceState: Bundle?) {
        window.setBackgroundDrawableResource(android.R.drawable.screen_background_dark_transparent)
        initParam()
        initVideoView()
    }

    override fun onStart() {
        super.onStart()
        exoPlayer?.setMediaItem(MediaItem.fromUri(originVideoUrl))
        exoPlayer?.prepare()
        exoPlayer?.play()
    }

    override fun onPause() {
        super.onPause()
        exoPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.stop()
        exoPlayer?.release()
    }

    private fun initParam() {
        originVideoUrl = intent.getStringExtra(KEY_VIDEO_URL).orEmpty()
    }

    private fun initVideoView() {
        val styledPlayerView = StyledPlayerView(this)
        val screenWidth = ViewUtil.getScreenDisplay(this).first()
        styledPlayerView.layoutParams = ConstraintLayout.LayoutParams(screenWidth, 0).apply {
            leftToLeft = R.id.content_layout
            topToTop = R.id.content_layout
            rightToRight = R.id.content_layout
            bottomToBottom = R.id.content_layout
            dimensionRatio = "h,16:9"
        }
        this.findViewById<ConstraintLayout>(R.id.content_layout).addView(styledPlayerView)
        styledPlayerView.player = getPlayer()
        exoPlayer?.addAnalyticsListener(object : AnalyticsListener {

            override fun onPlayWhenReadyChanged(
                eventTime: AnalyticsListener.EventTime,
                playWhenReady: Boolean,
                state: Int
            ) {
                super.onPlaybackStateChanged(eventTime, state)
                if (lastPlayState != 0) {
                    val costTime = SystemClock.elapsedRealtime() - timeStamp
                    Log.d("VideoActivity", "last player state is $lastPlayState cost time $costTime current state is $state")
                }
                timeStamp = SystemClock.elapsedRealtime()
                lastPlayState = state
            }
        })
    }

    private fun getPlayer(): ExoPlayer? {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(this).build()
        }
        return exoPlayer
    }
}