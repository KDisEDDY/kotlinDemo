package com.eddyjyliu.scrollconflict.eleme

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class CouponView @JvmOverloads constructor(context: Context?, @Nullable attrs: AttributeSet? = null, defStyleAttr: Int = -1) : View(context, attrs, defStyleAttr) {
    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        val radius = width / 2
        canvas.drawCircle(radius.toFloat(), 0f, radius.toFloat(), mPaint)
        canvas.drawCircle(radius.toFloat(), height.toFloat(), radius.toFloat(), mPaint)
        canvas.restore()
    }

    init {
        mPaint.style = Paint.Style.FILL
        mPaint.color = Color.WHITE
    }
}