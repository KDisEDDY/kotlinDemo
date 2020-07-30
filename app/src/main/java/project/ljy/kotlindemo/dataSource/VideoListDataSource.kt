package project.ljy.kotlindemo.dataSource

import android.annotation.SuppressLint
import android.util.Log
import okhttp3.ResponseBody
import okio.Buffer
import project.ljy.kotlindemo.data.VideoList
import project.ljy.kotlindemo.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.charset.Charset
import javax.inject.Inject


/**
 * 数据业务层
 * 直接返回给UI的可展示数据
 */
// a holly shit question, why the inject need to add in the constructor
class VideoListDataSource @Inject constructor(private var apiService: ApiService) {

    companion object {
        const val TAG = "VideoListDataSource"
    }

    val Utf8Charset = Charset.forName ("UTF-8")

    fun getVideoList(callback: Callback<VideoList>) {
        apiService.getDailyVideoList().enqueue(callback)
    }

    @SuppressLint("CheckResult")
    fun getVideoListInFile(callback: Callback<VideoList>?) {
        val dataSourceCallback = object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(TAG, "getVideoListInFile fail ${t.printStackTrace()} ")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful) {
                    Log.d(TAG, "getVideoListInFile success. Downloading the file ${response.body()?.source()}")
//                    try {
                    response.body()!!.source().use { responseBody ->
                        while (!responseBody.exhausted()) {
                            val responseBodyLine = responseBody.readUtf8Line()
                            Log.d(TAG, responseBodyLine)
                        }
                    }
//                    } catch (e: EOFException) {
//                        Log.d(TAG, "catch the EOFException")
//                    }

                }
            }
        }
        apiService.getDailyVideoListFile().enqueue(dataSourceCallback)
    }
}
