package project.ljy.kotlindemo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import project.ljy.kotlindemo.component.DaggerApplicationComponent

class MyApplication: Application() {
    //it is used the 'rebuild' to create the DaggerApplicationComponent
    val appComponent = DaggerApplicationComponent.create()

    override fun onCreate() {
        Fresco.initialize(this)
        super.onCreate()
    }
}