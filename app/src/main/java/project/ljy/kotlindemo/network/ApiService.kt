package project.ljy.kotlindemo.network

import project.ljy.kotlindemo.data.VideoList
import retrofit2.http.GET

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
    fun getDailyVideoList():  retrofit2.Call<VideoList>
}