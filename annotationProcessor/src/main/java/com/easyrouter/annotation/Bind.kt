package com.easyrouter.annotation

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FIELD)
annotation class Bind(val viewId: Int = -1)
