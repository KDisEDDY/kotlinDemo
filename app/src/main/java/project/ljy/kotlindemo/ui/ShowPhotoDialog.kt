package project.ljy.kotlindemo.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.adapter.PhotoCheckAdapter

/**
 * ClassName: ShowPhotoDialog
 * function:
 * Created by EDDY
 * CreateTime:2018/5/7
 */
class ShowPhotoDialog(context: Context) : Dialog(context , R.style.commonDialog) {

    var mPhotoList: MutableList<String>

    private var mShowPhotoRecycleView : PhotoCheckRecyclerView
    private var mAdapter : PhotoCheckAdapter
    private var mCloseImg : ImageView


    init {
        val view : View = LayoutInflater.from(context).inflate(R.layout.dialog_show_photo , null)
        mShowPhotoRecycleView = view.findViewById(R.id.view_photo_check)
        mCloseImg = view.findViewById(R.id.iv_close)
        setContentView(view)
        window?.let {
            it.decorView.setPadding(0,0,0,0)
            it.attributes.width = WindowManager.LayoutParams.MATCH_PARENT
            it.attributes.height = WindowManager.LayoutParams.WRAP_CONTENT
        }
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        mPhotoList = mutableListOf()
        mAdapter = PhotoCheckAdapter(context,mPhotoList)
        mShowPhotoRecycleView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mShowPhotoRecycleView.adapter = mAdapter
        buttonOperation()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun build() : ShowPhotoDialog{
        mAdapter.addList(mPhotoList)
        mAdapter.notifyDataSetChanged()
        return this
    }

    private fun buttonOperation(){
        mCloseImg.setOnClickListener({
            if(isShowing){
                dismiss()
            }
        })

        

    }
}