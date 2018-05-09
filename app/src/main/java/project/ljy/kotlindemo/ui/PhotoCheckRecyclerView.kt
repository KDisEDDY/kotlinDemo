package project.ljy.kotlindemo.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

/**
 * ClassName: PhotoCheckRecyclerView
 * function: 横向的图片滑动查看器
 * Created by EDDY
 * CreateTime:2018/5/9
 */
class PhotoCheckRecyclerView: RecyclerView {

    //图片列表页
    var mPhotoList: MutableList<String>
//    private lateinit var mGestureDetector : GestureDetector

    //主构造函数的实现块区域
    constructor(context: Context , attrs: AttributeSet? ,defStyle: Int) : super(context, attrs, defStyle){
        mPhotoList = mutableListOf()
    }

    constructor(context: Context , attrs : AttributeSet?) : this(context , attrs , 0)

}