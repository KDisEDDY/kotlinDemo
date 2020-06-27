package com.eddyjyliu.scrollconflict.uiwidget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.core.view.NestedScrollingParent3
import androidx.core.view.NestedScrollingParentHelper
import androidx.core.view.ViewCompat
import java.lang.Math.abs

class MyNestedScrollingParentView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr), NestedScrollingParent3 {
    private var nestedScrollingParentHelper = NestedScrollingParentHelper(this)
    private val viewRect = Rect()

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) = nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type)

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int) = (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        getLocalVisibleRect(viewRect)
        //计算出剩余滑动距离 remindScrollY
        val remindScrollY = measuredHeight - viewRect.bottom
        if (consumed.size >= 2) {
            //dy > remindScrollY consumed[1] = remindScrollY; unConsumedY = dy - remindScrollY
            consumed[1] = if (kotlin.math.abs(dy) > kotlin.math.abs(remindScrollY)) {
                remindScrollY
            } else {
                dy
            }
            consumed[0] = dx
        }
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        scrollBy(dxConsumed, dyConsumed)
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        scrollBy(dxConsumed, dyConsumed)
    }

    override fun onStopNestedScroll(target: View, type: Int) = nestedScrollingParentHelper.onStopNestedScroll(target, type)
}