package project.ljy.kotlindemo

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory
import okhttp3.OkHttpClient
import project.ljy.kotlindemo.component.ApplicationComponent
import project.ljy.kotlindemo.component.DaggerApplicationComponent
import project.ljy.kotlindemo.network.ClientManager

class MyApplication: Application() {
    //it is used the 'rebuild' to create the DaggerApplicationComponent
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        initFresco(context = this, ClientManager.instance)
    }

    private fun initFresco(context: Context, client: OkHttpClient) {
        val pipelineConfig = OkHttpImagePipelineConfigFactory
            .newBuilder(context, client)
            .build()
        Fresco.initialize(context, pipelineConfig)
    }
}