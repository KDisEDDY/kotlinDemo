package com.eddyjyliu.scrollconflict.eleme

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class DrawableLeftTextView : AppCompatTextView {
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?,
                defStyle: Int) : super(context, attrs, defStyle) {
    }

    constructor(context: Context?) : super(context) {}

    override fun onDraw(canvas: Canvas) {
        val drawables: Array<Drawable> = compoundDrawables
        if(drawables.isNotEmpty()) {
            val drawableLeft = drawables[0]
            val textWidth: Float = paint.measureText(text.toString())
            val drawablePadding: Int = compoundDrawablePadding
            val drawableWidth: Int = drawableLeft.intrinsicWidth
            val bodyWidth = textWidth + drawableWidth + drawablePadding
            canvas.translate((width - bodyWidth) / 2, 0f)
        }
        super.onDraw(canvas)
    }
}