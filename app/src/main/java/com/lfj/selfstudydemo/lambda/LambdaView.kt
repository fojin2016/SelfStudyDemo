package com.lfj.selfstudydemo.lambda

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.item_view_lambda.view.*

/**
 * @description
 * @author LFJ
 * @date   2020/10/21 15:48
 */
class LambdaView : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    init {
        View.inflate(context, R.layout.item_view_lambda, this)



    }

    fun setOnclick(l: (View) -> Unit) {
        textLambda.setOnClickListener(l)
    }

}