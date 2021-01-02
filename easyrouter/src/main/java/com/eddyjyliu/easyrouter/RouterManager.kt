package com.eddyjyliu.easyrouter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * 路由Manager
 */
object RouterManager {

    /**
     * 注册的路由表
     */
    private val routerMap = HashMap<String, Class<Activity>>()

    /**
     * 路由表注册功能
     */
    fun register(key: String, cls: Class<Activity>) {
        routerMap[key] = cls
    }

    /**
     * 路由表跳转功能
     */
    fun go(context: Context, key: String, bundle: Bundle) {
        routerMap[key]?.javaClass?.let{
            context.startActivity(Intent(context, it))
        }
    }
}