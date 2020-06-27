package com.eddyjyliu.scrollconflict.uiwidget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.NestedScrollingParent3
import androidx.core.view.NestedScrollingParentHelper
import androidx.core.view.ViewCompat
import com.eddyjyliu.scrollconflict.R

class ElemeNestedScrollLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
        FrameLayout(context, attrs, defStyleAttr), NestedScrollingParent3{

    private var downEndY = 0f

    private var nestedScrollingParentHelper = NestedScrollingParentHelper(this)

    private lateinit var topBar: View
    private lateinit var contentLayout: ConstraintLayout

    private var topBarHeight = 0f;

    override fun onFinishInflate() {
        super.onFinishInflate()
        topBar = findViewById(R.id.cl_top_bar)
        contentLayout = findViewById(R.id.cl_content)
    }

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type)
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int) = (axes and ViewCompat.SCROLL_AXIS_VERTICAL) != 0

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        val contentTransY = contentLayout.translationY - dy.toFloat()
        //处理上滑，在preScroll中直接消费滑动事件
        if (dy > 0) {
            if (contentTransY >= topBarHeight) {
                translationByConsume(contentLayout, contentTransY, consumed, dy.toFloat())
            } else {
                translationByConsume(contentLayout, topBarHeight, consumed, (contentLayout.translationY - topBarHeight))
            }
        }
        if (dy < 0 && !target.canScrollVertically(-1)) {
            //处理下滑，在preScroll中直接消费滑动事件
            if (contentTransY in topBarHeight..downEndY) {
                translationByConsume(contentLayout, contentTransY, consumed, dy.toFloat())
            } else {
                translationByConsume(contentLayout, downEndY, consumed, downEndY - contentLayout.translationY)
            }
        }
    }

    private fun translationByConsume(view: View, translationY: Float,
    consumed: IntArray, consumedDy: Float) {
        consumed[1] = consumedDy.toInt();
        view.translationY = translationY;
    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {

    }

    override fun onNestedScroll(target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        topBarHeight = topBar.measuredHeight.toFloat()
        //
        downEndY = measuredHeight.toFloat() / 3 * 2
    }

    override fun onStopNestedScroll(target: View, type: Int) {
       nestedScrollingParentHelper.onStopNestedScroll(target, type)
    }
}