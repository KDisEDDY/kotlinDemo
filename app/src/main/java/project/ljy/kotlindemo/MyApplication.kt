package project.ljy.kotlindemo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * ClassName: MyApplication
 * function:
 * Created by EDDY
 * CreateTime:2018/4/26
 */
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}