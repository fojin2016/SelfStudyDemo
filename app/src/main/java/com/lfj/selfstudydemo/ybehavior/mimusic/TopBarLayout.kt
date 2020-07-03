package com.lfj.selfstudydemo.ybehavior.mimusic

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * @author
 * @date
 */
class TopBarLayout : ConstraintLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
            measuredHeight + getStatusBarHeight(),
            MeasureSpec.EXACTLY
        )
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec)
    }

    /**
     *获取状态栏高度
     */
    fun getStatusBarHeight(): Int {

        var resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")

        return context.resources.getDimensionPixelSize(resourceId)

    }

}