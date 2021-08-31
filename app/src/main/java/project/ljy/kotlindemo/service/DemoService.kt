package project.ljy.kotlindemo.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class DemoService: Service() {

    private val serviceBinder = Binder()

    override fun onBind(intent: Intent?): IBinder {
        return serviceBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}