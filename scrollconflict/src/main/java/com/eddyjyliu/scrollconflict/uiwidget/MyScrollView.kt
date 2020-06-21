package com.eddyjyliu.scrollconflict.uiwidget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.core.view.get

/**
 * 外部拦截法
 * 外部滑动控件根据条件判断是否需要拦截
 */
class MyScrollView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
        ScrollView(context, attrs, defStyleAttr) {

    private var mLastY = 0f

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        var intercept = false
        when(ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                //当事件为actiondown时，不能拦截，否则之后的事件就全部被父控件全拦截了
                intercept = false
                super.onInterceptTouchEvent(ev)
            }
            MotionEvent.ACTION_MOVE -> {
                val childScrollView = findScrollViewChild(this)
                childScrollView?.let {
                    val deltaY = ev.y - mLastY
                    //判断子ScrollView是否滑动到顶部或者顶部
                    val isChildScrolledTop = deltaY > 0 && !childScrollView.canScrollVertically(-1)
                    val isChildScrolledBottom = deltaY < 0 && !childScrollView.canScrollVertically(1)
                    intercept = isChildScrolledTop || isChildScrolledBottom
                }?:run{
                    intercept = false
                }
            }
            MotionEvent.ACTION_UP -> {
                intercept = false
            }
        }
        mLastY = ev?.y ?: 0f
        return intercept
    }

    /**
     * 从当前View一直向下遍历，找到第一个具有滑动功能的子ScrollView
     */
    private fun findScrollViewChild(parentView: View) : View? {
        if (parentView is ViewGroup && (parentView as? ViewGroup)?.childCount?: 0 > 0) {
            if (parentView[0] is ScrollView) {
                return parentView[0]
            } else {
                findScrollViewChild(parentView[0])
            }
        } else {
            return null
        }
        return null
    }
}