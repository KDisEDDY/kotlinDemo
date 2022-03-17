package project.ljy.kotlindemo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.ljy.kotlindemo.MyApplication
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.data.VideoList
import project.ljy.kotlindemo.adapter.VideoListAdapter
import project.ljy.kotlindemo.dataSource.VideoListDataSource
import project.ljy.kotlindemo.listener.RecycleViewItemClickListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

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

    lateinit var mRecyclerList : RecyclerView
    lateinit var mListAdapter: VideoListAdapter
    @Inject lateinit var mDataSource: VideoListDataSource

    companion object {
        const val TAG = "VideoListFragment"
    }

    override fun onAttach(context: Context) {
        (this.activity?.applicationContext as? MyApplication)?.appComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let {
            mListAdapter = VideoListAdapter(it, mutableListOf())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_video_list, container , false)
        mRecyclerList = view.findViewById(R.id.v_recycler)
        mRecyclerList.layoutManager = LinearLayoutManager(activity)
        mRecyclerList.adapter = mListAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideoList()

        mListAdapter.setOnItemClickListener(object: RecycleViewItemClickListener.ItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                mListAdapter.getItem(position)?.data?.playUrl?.let {
                    gotoVideoActivity(it)
                }
            }
        })
    }

    private fun gotoVideoActivity(playUrl: String) {
        VideoActivity.gotoVideoActivity(requireActivity(), playUrl)
    }

    private fun gotoPhotoDialog(position: Int) {
        val itemPhoto  = mListAdapter.getItem(position)!!.data!!.cover
        context?.let {
            val dialog : ShowPhotoDialog = ShowPhotoDialog(it).apply {
                mPhotoList = mutableListOf(itemPhoto!!.feed!!,itemPhoto.detail!!,itemPhoto.blurred!!)
            }.build()
            dialog.show()
        }
    }

    private fun getVideoList(){
        mDataSource.getVideoList(object: Callback<VideoList> {
            override fun onFailure(call: Call<VideoList>?, t: Throwable?) {
                Log.i(TAG, "get VideoList fail ${t?.message}")
            }

            override fun onResponse(call: Call<VideoList>?, response: Response<VideoList>) {
                val videoList = response.body()
                //过滤掉没有数据的item
                val filterList = videoList?.itemList!!.filter { item: VideoList.ItemList
                    -> item.data?.dataType.equals("VideoBeanForClient") }
                this@VideoListFragment.mRecyclerList.post {
                    mListAdapter.addList(filterList)
                    mListAdapter.notifyDataSetChanged()
                    Log.i(TAG, "get VideoList success $filterList")
                }
            }
        })
    }
}