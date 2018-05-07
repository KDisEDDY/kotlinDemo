package project.ljy.kotlindemo.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import project.ljy.kotlindemo.utils.SystemUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Title: RetrofitManager
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
object RetrofitManager{

    private var mClient: OkHttpClient? = null
    private var mRetrofit: Retrofit? = null

    val mService: ApiService by lazy { getRetrofit()!!.create(ApiService::class.java)}

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                    // Provide your custom parameter here
                    .addQueryParameter("phoneSystem", SystemUtil.systemVersion)
                    .addQueryParameter("phoneModel", SystemUtil.systemModel)
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 设置头
     */
    private fun addHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                    // Provide your custom header here
                    .method(originalRequest.method(), originalRequest.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    private fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            synchronized(RetrofitManager::class.java) {
                if (mRetrofit == null) {
                    //添加一个log拦截器,打印所有的log
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    //可以设置请求过滤的水平,body,basic,headers
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                    mClient = OkHttpClient.Builder()
                            .addInterceptor(addQueryParameterInterceptor())  //参数添加
                            .addInterceptor(addHeaderInterceptor()) // token过滤
                            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
                            .connectTimeout(60L, TimeUnit.SECONDS)
                            .readTimeout(60L, TimeUnit.SECONDS)
                            .writeTimeout(60L, TimeUnit.SECONDS)
                            .build()

                    // 获取retrofit的实例
                    mRetrofit = Retrofit.Builder()
                            .baseUrl(UrlConstant.BASE_URL)  //自己配置
                            .client(mClient!!)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return mRetrofit
    }


}
