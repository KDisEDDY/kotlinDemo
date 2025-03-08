package project.ljy.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facebook.drawee.view.SimpleDraweeView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseRecyclerViewAdapter

/**
 * ClassName: PhotoCheckAdapter
 * function:
 * Created by EDDY
 * CreateTime:2018/5/9
 */
class PhotoCheckAdapter(context:Context , mDataList : MutableList<String>) : BaseRecyclerViewAdapter<PhotoCheckAdapter.ViewHolder , String>(context, mDataList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_photo_check, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item  = mList[position]
        if(item.isNotEmpty()){
            holder.mCurPhoto.setImageURI(item)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCurPhoto: SimpleDraweeView = itemView.findViewById<View>(R.id.iv_cur_photo) as SimpleDraweeView

    }
}