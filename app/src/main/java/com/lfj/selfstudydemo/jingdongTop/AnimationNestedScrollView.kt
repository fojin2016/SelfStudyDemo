package com.lfj.selfstudydemo.jingdongTop

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView


/**
 * @author
 * @date
 */
class AnimationNestedScrollView :NestedScrollView {


     var listener: OnAnimationScrollChangeListener? = null


    constructor(context: Context):super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    fun setOnAnimationScrollListener(listener: OnAnimationScrollChangeListener){
       this.listener = listener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        listener?.onScrollChanged(scrollY*0.65f) //x0.65 使位移效果更加平滑 解决手指按住停留时抖动问题
    }

    interface OnAnimationScrollChangeListener {
        fun onScrollChanged(dy: Float)
    }

}