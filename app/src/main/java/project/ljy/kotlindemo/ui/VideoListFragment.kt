package project.ljy.kotlindemo.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
class VideoListFragment : Fragment() {

    var mRecyclerList : RecyclerView? = null
    var mListAdapter: VideoListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let {
            mListAdapter = VideoListAdapter(it, mutableListOf())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_video_list, container , false)
        mRecyclerList = view.findViewById(R.id.v_recycler)
        mRecyclerList?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = mListAdapter
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getVideoList()

        mListAdapter?.setOnItemClickListener(object: RecycleViewItemClickListener.ItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                val itemPhoto  = mListAdapter?.getItem(position)?.data?.cover
                activity?.let {
                    val dialog : ShowPhotoDialog = ShowPhotoDialog(it).apply {
                        mPhotoList = mutableListOf(itemPhoto!!.feed!!,itemPhoto.detail!!,itemPhoto.blurred!!)
                    }.build()
                    dialog.show()
                }

            }
        })
    }

    private fun getVideoList(){
        RetrofitManager.mService.getDailyVideoList().enqueue(object: Callback<VideoList> {
            override fun onFailure(call: Call<VideoList>, t: Throwable) {
                Log.i("NetWorkResponse" ,t.toString())
            }

            override fun onResponse(call: Call<VideoList>, response: Response<VideoList>) {
                val videoList = response.body()
                //过滤掉没有数据的item
                val filterList = videoList?.itemList!!.filter { item: VideoList.ItemList
                    -> item.data?.dataType.equals("VideoBeanForClient") }
                mListAdapter?.addList(filterList)
            }
        })
    }
}