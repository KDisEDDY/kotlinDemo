package project.ljy.kotlindemo.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_video_list.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.data.VideoList
import project.ljy.kotlindemo.adapter.VideoListAdapter
import project.ljy.kotlindemo.listener.RecycleViewItemClickListener
import project.ljy.kotlindemo.network.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Title: VideoListFragment
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
class VideoListFragment : Fragment() {

    lateinit var mListAdapter: VideoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mListAdapter = VideoListAdapter(context, mutableListOf())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_video_list, container , false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v_recycler.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mListAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getVideoList()

        mListAdapter.setOnItemClickListener(object: RecycleViewItemClickListener.ItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                val itemPhoto  = mListAdapter.getItem(position).data!!.cover
                val dialog : ShowPhotoDialog = ShowPhotoDialog(context).apply {
                    itemPhoto?.let {
                        mPhotoList = ArrayList<String>().apply{
                            add(it.feed)
                            add(it.detail)
                            add(it.blurred)
                        }
                    }
                }.build()
                dialog.show()
            }
        })
    }

    private fun getVideoList(){
        RetrofitManager.mService.getDailyVideoList().enqueue(object: Callback<VideoList> {
            override fun onFailure(call: Call<VideoList>?, t: Throwable?) {
                Log.i("NetWorkResponse" ,t.toString())
            }

            override fun onResponse(call: Call<VideoList>?, response: Response<VideoList>) {
                val videoList = response.body()
                //过滤掉没有数据的item
                val filterList = videoList?.itemList!!.filter { item: VideoList.ItemList
                    -> item.data?.dataType.equals("VideoBeanForClient") }
                mListAdapter.addList(filterList)
            }
        })
    }
}