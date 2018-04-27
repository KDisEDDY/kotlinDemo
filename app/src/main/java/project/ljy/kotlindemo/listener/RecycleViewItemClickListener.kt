package project.ljy.kotlindemo.listener

import android.view.View

/**
 * Title: RecycleViewItemClickListener
 * Description:
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2017/2/16
 * Version: 1.0
 */
interface RecycleViewItemClickListener {
    interface ItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    interface LongItemClickListener {
        fun onLongItemClick(v: View, position: Int)
    }
}
