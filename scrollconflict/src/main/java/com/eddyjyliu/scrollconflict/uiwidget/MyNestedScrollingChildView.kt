package com.eddyjyliu.scrollconflict.uiwidget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.core.view.NestedScrollingChild3
import androidx.core.view.NestedScrollingChildHelper
import androidx.core.view.ViewCompat

class MyNestedScrollingChildView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
        LinearLayout(context, attrs, defStyleAttr), NestedScrollingChild3 {
    private var nestedScrollingChildHelper: NestedScrollingChildHelper = NestedScrollingChildHelper(this)

    /**
     * Used during scrolling to retrieve the new offset within the window.
     */
    private val mScrollOffset = IntArray(2)
    private val mScrollConsumed = IntArray(2)

    private var mLastMotionY = 0
    init {
        nestedScrollingChildHelper.isNestedScrollingEnabled = true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (nestedScrollingChildHelper.isNestedScrollingEnabled) {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL, ViewCompat.TYPE_TOUCH)
                }

                MotionEvent.ACTION_MOVE -> {
                    var deltaY = mLastMotionY - event.y.toInt()
                    if(dispatchNestedPreScroll(0, deltaY, mScrollConsumed, mScrollOffset, ViewCompat.TYPE_TOUCH)) {
                        deltaY -= mScrollConsumed[1]
                    }

                    val oldY = scrollY

                    scrollBy(0, deltaY)

                    val scrolledDeltaY = scrollY - oldY
                    val unconsumedY = deltaY - scrolledDeltaY

                    dispatchNestedScroll(0, scrolledDeltaY, 0, unconsumedY,
                            mScrollOffset, ViewCompat.TYPE_TOUCH, mScrollConsumed)
                }

                MotionEvent.ACTION_UP -> {
                    stopNestedScroll(ViewCompat.TYPE_TOUCH)
                }
            }
            mLastMotionY = event?.y?.toInt() ?: 0
        }
        return super.onTouchEvent(event)
    }

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?, type: Int, consumed: IntArray)
            = nestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed)

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?, type: Int)
            = nestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type)

    override fun dispatchNestedScroll(dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, offsetInWindow: IntArray?)
            = nestedScrollingChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow)

    override fun isNestedScrollingEnabled() = nestedScrollingChildHelper.isNestedScrollingEnabled

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?, type: Int)
            = nestedScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type)

    override fun dispatchNestedPreScroll(dx: Int, dy: Int, consumed: IntArray?, offsetInWindow: IntArray?)
            = nestedScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow)

    override fun stopNestedScroll(type: Int) = nestedScrollingChildHelper.stopNestedScroll(type)

    override fun stopNestedScroll() {
        nestedScrollingChildHelper.stopNestedScroll()
    }

    override fun hasNestedScrollingParent(type: Int) = nestedScrollingChildHelper.hasNestedScrollingParent(type)

    override fun hasNestedScrollingParent(): Boolean {
        return nestedScrollingChildHelper.hasNestedScrollingParent()
    }

    override fun dispatchNestedPreFling(velocityX: Float, velocityY: Float) = nestedScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY)

    override fun setNestedScrollingEnabled(enabled: Boolean) {
        nestedScrollingChildHelper.isNestedScrollingEnabled = enabled
    }

    override fun dispatchNestedFling(velocityX: Float, velocityY: Float, consumed: Boolean)
            = nestedScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed)

    override fun startNestedScroll(axes: Int, type: Int) = nestedScrollingChildHelper.startNestedScroll(axes, type)

    override fun startNestedScroll(axes: Int) = nestedScrollingChildHelper.startNestedScroll(axes)
}