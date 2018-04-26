package project.ljy.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.util.Log
import project.ljy.kotlindemo.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        RetrofitManager.service.getDailyVideoList().enqueue(object:Callback<VideoList> {
//            override fun onFailure(call: Call<VideoList>?, t: Throwable?) {
//                Log.i("NetWorkResponse" ,t.toString())
//            }
//
//            override fun onResponse(call: Call<VideoList>?, response: Response<VideoList>?) {
//                var videoList = response?.body()
//            }
//        })
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ll_frag_container , VideoListFragment())
        transaction.commitAllowingStateLoss()
    }
}
