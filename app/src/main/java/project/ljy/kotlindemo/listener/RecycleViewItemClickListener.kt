package project.ljy.kotlindemo.listener

import android.view.View

/**
 * Title: RecycleViewItemClickListener
 * Description:
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
