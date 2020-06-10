package com.lfj.selfstudydemo.scroll

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView
import androidx.annotation.AttrRes
import com.lfj.selfstudydemo.Yr
import kotlinx.android.synthetic.main.out_side_scroll.view.*

/**
 * @author
 * @date
 */
class OutSideScrollView : ScrollView {


    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    var mLast = 0

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        var intercepted = false

        var y = ev?.y?.toInt()!!

        when (ev?.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                intercepted = false
                super.onInterceptTouchEvent(ev)
            }

            MotionEvent.ACTION_MOVE -> {

                var dety = y - mLast

                //判断子ScrollView是否滑动到顶部或者顶部
                var isChildScrolledTop = dety > 0 && !scrollViewIn.canScrollVertically(-1)

                var isChildScrolledBottom = dety < 0 && !scrollViewIn.canScrollVertically(-1)

                intercepted = isChildScrolledBottom || isChildScrolledTop

                Yr.d(intercepted)

            }

            MotionEvent.ACTION_UP -> {
                intercepted = false
            }
        }

        mLast = y

        return intercepted
    }

}