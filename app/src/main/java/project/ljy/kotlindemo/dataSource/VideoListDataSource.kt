package project.ljy.kotlindemo.dataSource

import project.ljy.kotlindemo.data.VideoList
import project.ljy.kotlindemo.network.ApiService
import javax.inject.Inject
import retrofit2.Callback

// a holly shit question, why the inject need to add in the constructor
class VideoListDataSource @Inject constructor(private var apiService: ApiService) {

    fun getVideoList(callback: Callback<VideoList>) {
        apiService.getDailyVideoList().enqueue(callback)
    }
}
