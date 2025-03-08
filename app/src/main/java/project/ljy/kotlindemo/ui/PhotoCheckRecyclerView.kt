package project.ljy.kotlindemo.ui

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * ClassName: PhotoCheckRecyclerView
 * function: 横向的图片滑动查看器
 * Created by EDDY
 * CreateTime:2018/5/9
 */
class PhotoCheckRecyclerView: RecyclerView {

    //主构造函数的实现块区域
    constructor(context: Context , attrs: AttributeSet? ,defStyle: Int) : super(context, attrs, defStyle)

    constructor(context: Context , attrs : AttributeSet?) : this(context , attrs , 0)

}