package project.ljy.kotlindemo.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseRecyclerViewAdapter
import project.ljy.kotlindemo.data.VideoList
import com.facebook.drawee.generic.GenericDraweeHierarchy

import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder

/**
 * ClassName: VideoListAdapter
 * function: 视频列表adapter
 * Created by EDDY
 * CreateTime:2018/4/26
 */
class VideoListAdapter(mContext: Context, mItemList: MutableList<VideoList.ItemList>) : BaseRecyclerViewAdapter<VideoListAdapter.ViewHolder, VideoList.ItemList>(mContext,mItemList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_videolist, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item  = mList!![position]
        holder.mTitleTxt.text = item.data?.title
        setImage(holder.mPrePhotoImg, item.data?.cover?.feed)
    }

    private fun setImage(draweeView: SimpleDraweeView, imgUrl: String?) {
        imgUrl?.isBlank() ?: return
        // 设置叠层
        val builder = GenericDraweeHierarchyBuilder(draweeView.resources)
        val hierarchy: GenericDraweeHierarchy = builder
            .setFadeDuration(300)
            .setFailureImage(R.mipmap.ic_launcher_round)
            .build()
        draweeView.hierarchy = hierarchy

        val uri = Uri.parse(imgUrl)

        val listener = object : BaseControllerListener<ImageInfo>() {
            override fun onSubmit(id: String?, callerContext: Any?) {
                super.onSubmit(id, callerContext)
            }
        }
        val controller: DraweeController = Fresco.newDraweeControllerBuilder()
            .setUri(uri)
            .setTapToRetryEnabled(true)
            .setOldController(draweeView.controller)
            .setControllerListener(listener)
            .build()

        draweeView.controller = controller
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTitleTxt: TextView = itemView.findViewById<View>(R.id.tv_title) as TextView
        var mPrePhotoImg: SimpleDraweeView = itemView.findViewById<View>(R.id.iv_preview_photo) as SimpleDraweeView

    }

    companion object {
        private val TAG = "Logcat_info"
    }
}
