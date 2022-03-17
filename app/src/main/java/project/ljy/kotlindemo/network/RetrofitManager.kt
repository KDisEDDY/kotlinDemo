package project.ljy.kotlindemo.network

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Title: RetrofitManagerØ
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
@Module
class RetrofitManager{

    var mRetrofit: Retrofit? = null

    @Singleton
    @Provides
    public fun getService() : ApiService {
        return getRetrofit()!!.create(ApiService::class.java)
    }


    private fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            synchronized(RetrofitManager::class.java) {
                if (mRetrofit == null) {
                    //添加一个log拦截器,打印所有的log
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    //可以设置请求过滤的水平,body,basic,headers
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

                    // 获取retrofit的实例
                    mRetrofit = Retrofit.Builder()
                            .baseUrl(UrlConstant.BASE_URL)  //自己配置
                            .client(ClientManager.instance)
                            .callbackExecutor(Executors.newSingleThreadExecutor())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                }
            }
        }
        return mRetrofit
    }

    class ChunksInterceptor: Interceptor {

        val Utf8Charset = Charset.forName ("UTF-8")

        override fun intercept (chain: Interceptor.Chain): Response {
            val originalResponse = chain.proceed (chain.request ())
            val responseBody = originalResponse.body
            val source = responseBody!!.source ()

            val buffer = Buffer () // We create our own Buffer

            // Returns true if there are no more bytes in this source
            while (!source.exhausted ()) {
                val readBytes = source.read (buffer, Long.MAX_VALUE) // We read the whole buffer
                val data = buffer.readString (Utf8Charset)

                Log.d ("ChunksInterceptor","Read: $readBytes bytes")
                Log.d ("ChunksInterceptor", "Content: \n $data \n")
            }

            return originalResponse
        }
    }
}
