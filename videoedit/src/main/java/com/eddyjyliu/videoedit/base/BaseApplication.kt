package com.eddyjyliu.videoedit.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {


    companion object {
        lateinit var myApplicationContext: Context
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        base?.let {
            myApplicationContext = it
        }
    }


}