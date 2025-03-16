package project.ljy.kotlindemo.base

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.ljy.kotlindemo.listener.RecycleViewItemClickListener

/**
 * Title: BaseRecyclerViewAdapter
 * Description:
 * Author: 刘加彦
 * Date: 2018/4/26
 * Version: 1.0
 */
abstract class BaseRecyclerViewAdapter<T : RecyclerView.ViewHolder, S>(context: Context, list: MutableList<S>) : RecyclerView.Adapter<T>() {

    var mList: MutableList<S>? = null
    var mContext: Context? = null

    private var onItemClickListener: RecycleViewItemClickListener.ItemClickListener? = null

    private var onLongItemClickListener: RecycleViewItemClickListener.LongItemClickListener? = null

    init {
        this.mContext = context
        this.mList = list
    }

    /**
     * 需要使用点击事件时，重写onBindViewHolder时要调用父类方法，封装了监听在该方法
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: T, position: Int) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener { v ->
                onItemClickListener!!.onItemClick(v, holder.bindingAdapterPosition)
            }
        }
        if (onLongItemClickListener != null) {
            holder.itemView.setOnLongClickListener { v ->
                onLongItemClickListener!!.onLongItemClick(v, holder.bindingAdapterPosition)
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    fun setOnItemClickListener(onItemClickListener: RecycleViewItemClickListener.ItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setOnLongItemClickListener(onLongItemClickListener: RecycleViewItemClickListener.LongItemClickListener) {
        this.onLongItemClickListener = onLongItemClickListener
    }

    fun getItem(position: Int): S? {
        if (position < 0 && position > mList!!.size - 1) {
            try {
                throw Exception("the positiion is wrong")
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            return mList!![position]
        }
        return null
    }

    fun addList(newList: List<S>) {
        if (newList.isNotEmpty()) {
            mList!!.addAll(newList)
        }
    }
}
