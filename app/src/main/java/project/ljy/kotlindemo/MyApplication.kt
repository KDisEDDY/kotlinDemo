package project.ljy.kotlindemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco
import project.ljy.kotlindemo.component.DaggerApplicationComponent

class MyApplication: Application() {
    //it is used the 'rebuild' to create the DaggerApplicationComponent
    val appComponent = DaggerApplicationComponent.create()


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        Fresco.initialize(this)
        super.onCreate()
    }
}