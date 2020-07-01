package com.lfj.selfstudydemo.scroll

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

/**
 * @author
 * @date
 */
class InSideScrollView : ScrollView {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    var mLastY = 0

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        var y = ev?.y?.toInt()!!


        when (ev.actionMasked) {

            MotionEvent.ACTION_DOWN -> {
                parent.requestDisallowInterceptTouchEvent(true)
            }

            MotionEvent.ACTION_MOVE -> {
                var dey = y - mLastY

                var isScrolledTop = dey > 0 && !canScrollVertically(-1)
                var isScrolledBottom = dey < 0 && !canScrollVertically(-1)

                //根据自身是否滑动到顶部或者顶部来判断让父View拦截触摸事件
                if (isScrolledTop || isScrolledBottom) {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        mLastY = y
        return super.dispatchTouchEvent(ev)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        if (ev?.actionMasked == MotionEvent.ACTION_DOWN) {

            super.onInterceptTouchEvent(ev)
            return false
        }

        return true

    }
}