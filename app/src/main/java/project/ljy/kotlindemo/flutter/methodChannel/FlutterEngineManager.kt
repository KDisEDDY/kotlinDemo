package project.ljy.kotlindemo.flutter.methodChannel

import android.content.Context
import io.flutter.FlutterInjector
import io.flutter.embedding.android.FlutterEngineProvider
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.FlutterJNI
import io.flutter.embedding.engine.loader.FlutterLoader
import java.util.concurrent.atomic.AtomicBoolean

object FlutterEngineManager {
    lateinit var engine : FlutterEngine

    var isInit = AtomicBoolean(false)

    // 预加载
    fun preload(context: Context) {
        if (isInit.compareAndSet(false, true)) {
            val flutterLoader: FlutterLoader = FlutterInjector.instance().flutterLoader()
            engine = FlutterEngine(context, flutterLoader, FlutterJNI())
        }
    }

    fun getEngineInstance(): FlutterEngine {
        if (!isInit.get()) throw Throwable("the flutter engine is never init")
        return engine
    }
}