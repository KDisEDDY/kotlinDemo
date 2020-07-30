package project.ljy.kotlindemo.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import project.ljy.kotlindemo.data.VideoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Streaming

/**
 * Title: ApiService
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
interface ApiService {

    /**
     * 首页精选
     */
    @GET("v4/tabs/selected")
    fun getDailyVideoList():  Call<VideoList>

    //下载接口返回的数据是chunk编码的
    @Streaming
    @GET("v4/tabs/selected")
    fun getDailyVideoListFile(): Call<ResponseBody>
}