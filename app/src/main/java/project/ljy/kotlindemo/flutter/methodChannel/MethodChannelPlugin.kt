package project.ljy.kotlindemo.flutter.methodChannel

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel
import project.ljy.kotlindemo.flutter.methodChannel.ChannelConst.TO_VIDEO_FLUTTER_CHANNEL

class MethodChannelPlugin: FlutterPlugin {

    companion object {
        fun registerPlugin() {
            FlutterEngineManager.getEngineInstance().plugins.add(MethodChannelPlugin())
        }
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        val methodChannel = MethodChannel(binding.binaryMessenger, TO_VIDEO_FLUTTER_CHANNEL)
        methodChannel.setMethodCallHandler { call, result ->

        }
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {

    }
}