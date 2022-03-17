package project.ljy.kotlindemo.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

object ClientManager {

    val instance: OkHttpClient by lazy {
        //添加一个log拦截器,打印所有的log
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        builder.build()
    }

    val builder: OkHttpClient.Builder by lazy {
        //添加一个log拦截器,打印所有的log
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        OkHttpClient.Builder()
            .addInterceptor(addQueryParameterInterceptor())  //参数添加
            .addInterceptor(addHeaderInterceptor()) // token过滤
            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
            .connectTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(10L, TimeUnit.SECONDS)
            .writeTimeout(10L, TimeUnit.SECONDS)
            .sslSocketFactory(createSSLSocketFactory(), MyTrustManager())
    }

    private fun createSSLSocketFactory(): SSLSocketFactory {
        val sc = SSLContext.getInstance("TLS")
        return try {
            sc.init(null, arrayOf(MyTrustManager()), SecureRandom())
            sc.socketFactory
        } catch (throwable: Throwable) {
            sc.init(null, arrayOf(MyTrustManager()), SecureRandom())
            return sc.socketFactory
        }
    }

    /**
     * 设置公共参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url.newBuilder()
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
                .addHeader("Accept", "*/*")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept-Language", "zh-CN,zh")
                .method(originalRequest.method, originalRequest.body)
            val request = requestBuilder.build()
            chain.proceed(request)
        }
    }
}

class MyTrustManager: X509TrustManager {
    override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {

    }

    override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {

    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }

}