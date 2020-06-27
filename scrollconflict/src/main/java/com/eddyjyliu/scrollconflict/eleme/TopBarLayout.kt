package com.eddyjyliu.scrollconflict.eleme

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

class TopBarLayout @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0): ConstraintLayout(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val newHeightMeasureSpec: Int = MeasureSpec.makeMeasureSpec(measuredHeight + statusBarHeight, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec)
    }

    /**
     * 获取状态栏高度
     */
    private val statusBarHeight: Int
        private get() {
            val resourceId: Int = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            return context.resources.getDimensionPixelSize(resourceId)
        }
}