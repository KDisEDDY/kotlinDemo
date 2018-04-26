package project.ljy.kotlindemo

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
        fun onItemClickListener(v: View, position: Int)
    }

    interface LongItemClickListener {
        fun onLongItemClickListener(v: View, position: Int)
    }
}
