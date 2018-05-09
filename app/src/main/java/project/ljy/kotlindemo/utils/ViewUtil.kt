/**
 * Title: ViewUtil.java
 * Description:
 * Copyright: Copyright (c) 2013 luoxudong.com
 * Company:个人
 * Author 罗旭东 (hi@luoxudong.com)
 * Date 2013-10-11 下午2:24:40
 * Version 1.0
 */
package project.ljy.kotlindemo.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.RelativeLayout

object ViewUtil {
    /**
     * 获取控件宽度
     */
    fun getViewWith(v: View): Int {
        val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        v.measure(w, h)
        return v.measuredWidth
    }

    /**
     * 获取控件高度
     * @param v
     */
    fun getViewHeight(v: View): Int {
        val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        v.measure(w, h)
        return v.measuredHeight
    }

    fun getLayoutX(view: View): Int {
        val location = IntArray(2)
        val rect = Rect()
        view.getLocalVisibleRect(rect)
        view.getLocationInWindow(location) //获取在当前窗口内的绝对坐标
        view.getLocationOnScreen(location)//获取在整个屏幕内的绝对坐标
        return location[0]
    }

    fun getLayoutY(view: View): Int {
        val location = IntArray(2)
        view.getLocationInWindow(location) //获取在当前窗口内的绝对坐标
        view.getLocationOnScreen(location)//获取在整个屏幕内的绝对坐标
        return location[1]
    }

    /*
     * 设置控件所在的位置X，并且不改变宽高，
     * X为绝对位置，此时Y可能归0
     */
    fun setLayoutX(view: View, x: Int) {
        val margin = MarginLayoutParams(
                view.layoutParams)
        margin.setMargins(x, margin.topMargin, x + margin.width,
                margin.bottomMargin)
        val layoutParams = RelativeLayout.LayoutParams(
                margin)
        view.layoutParams = layoutParams
    }

    /*
     * 设置控件所在的位置Y，并且不改变宽高，
     * Y为绝对位置，此时X可能归0
     */
    fun setLayoutY(view: View, y: Int) {
        val margin = MarginLayoutParams(
                view.layoutParams)
        margin.setMargins(margin.leftMargin, y, margin.rightMargin, y + margin.height)
        val layoutParams = RelativeLayout.LayoutParams(
                margin)
        view.layoutParams = layoutParams
    }

    /*
     * 设置控件所在的位置YY，并且不改变宽高，
     * XY为绝对位置
     */
    fun setLayout(view: View, x: Int, y: Int) {
        val margin = MarginLayoutParams(
                view.layoutParams)
        margin.setMargins(x, y, 0, 0)
        val layoutParams = RelativeLayout.LayoutParams(
                margin)
        view.layoutParams = layoutParams
    }

    /**
     * 显示软键盘
     *
     */
    fun showInputMethod(activity: Activity, view: View) {
        val imm = activity.baseContext
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

    /**
     * 隐藏软键盘
     * @param activity
     */
    fun hiddenInputMethod(activity: Activity?) {
        // toggleSoftInput(activity);
        if (activity != null) {
            try {
                val imm = activity
                        .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(activity.currentFocus!!
                        .windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            } catch (e: Exception) {
            }

        }
    }

    /**
     * 显示或隐藏软键盘(如果输入法在窗口上已经显示，则隐藏，反之则显示)
     * @param context
     * @return void
     */
    fun toggleSoftInput(context: Context) {
        val imm = context
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }


    /**
     * 获取屏幕尺寸
     * @param context
     * @return
     */
    fun getScreenDispaly(context: Context): IntArray {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        //int width = windowManager.getDefaultDisplay().getWidth();
        //int height = windowManager.getDefaultDisplay().getHeight();
        val mPoint = Point()
        windowManager.defaultDisplay.getSize(mPoint)
        val width = mPoint.x
        val height = mPoint.y
        return intArrayOf(width, height)
    }
}
