package project.ljy.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseRecyclerViewAdapter
import project.ljy.kotlindemo.data.VideoList

/**
 * ClassName: VideoListAdapter
 * function: 视频列表adapter
 * Created by EDDY
 * CreateTime:2018/4/26
 */
class VideoListAdapter(mContext: Context, mItemList: MutableList<VideoList.ItemList>) : BaseRecyclerViewAdapter<VideoListAdapter.ViewHolder, VideoList.ItemList>(mContext,mItemList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_videolist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item  = mList[position]
        holder.mTitleTxt.text = item.data?.title
        if(!item.data?.title.isNullOrEmpty() && !item.data?.cover?.feed.isNullOrEmpty()){
            holder.mPrePhotoImg.setImageURI(item.data!!.cover!!.feed)
        } else {
            holder.mPrePhotoImg.setActualImageResource(R.mipmap.ic_launcher_round)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitleTxt: TextView = itemView.findViewById<View>(R.id.tv_title) as TextView
        var mPrePhotoImg: SimpleDraweeView = itemView.findViewById<View>(R.id.iv_preview_photo) as SimpleDraweeView

    }
}
