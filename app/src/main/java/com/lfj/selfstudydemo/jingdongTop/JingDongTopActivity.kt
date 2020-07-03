package com.lfj.selfstudydemo.jingdongTop

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.util.dp2px
import com.lfj.selfstudydemo.mvvm.util.screenWidth
import kotlinx.android.synthetic.main.activity_jing_dong_top.*

class JingDongTopActivity : AppCompatActivity() {


    private var LL_SEARCH_MIN_TOP_MARGIN = 0f
    private var LL_SEARCH_MAX_TOP_MARGIN = 0f
    private var LL_SEARCH_MAX_WIDTH = 0f
    private var LL_SEARCH_MIN_WIDTH = 0f
    private var TV_TITLE_MAX_TOP_MARGIN = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jing_dong_top)


        var titleLayoutParams = search_tv_title.layoutParams as ViewGroup.MarginLayoutParams

        var searchLayoutParams = search_ll_search.layoutParams as ViewGroup.MarginLayoutParams


        LL_SEARCH_MIN_TOP_MARGIN = dp2px(4.5f).toFloat() //布局关闭时顶部距离
        LL_SEARCH_MAX_TOP_MARGIN = dp2px(49f).toFloat()//布局默认展开时顶部距离


        LL_SEARCH_MAX_WIDTH = (screenWidth - dp2px(30f)).toFloat()//布局默认展开时的宽度

        LL_SEARCH_MIN_WIDTH = (screenWidth- dp2px(82f)).toFloat()//布局关闭时的宽度

        TV_TITLE_MAX_TOP_MARGIN = dp2px(11.5f).toFloat()

        search_sv_view.setOnAnimationScrollListener(object :
            AnimationNestedScrollView.OnAnimationScrollChangeListener {
            override fun onScrollChanged(dy: Float) {

                var searchLayoutNewTopMargin = LL_SEARCH_MAX_TOP_MARGIN -dy

                var searchLayoutNewWidth =  LL_SEARCH_MAX_WIDTH - dy * 1.3f//此处 * 1.3f 可以设置搜索框宽度缩放的速率

                var titleNewTopMargin =  (TV_TITLE_MAX_TOP_MARGIN - dy * 0.5)


                if (searchLayoutNewTopMargin < LL_SEARCH_MIN_TOP_MARGIN) {
                    searchLayoutNewTopMargin = LL_SEARCH_MIN_TOP_MARGIN;
                }


                if (searchLayoutNewWidth < LL_SEARCH_MIN_WIDTH) {
                    searchLayoutNewWidth = LL_SEARCH_MIN_WIDTH;
                }

                var titleAlpha = 255 * titleNewTopMargin /TV_TITLE_MAX_TOP_MARGIN

                if(titleAlpha < 0){
                    titleAlpha = 0.0
                }

              //设置相关控件的LayoutParams  此处使用的是MarginLayoutParams，便于设置params的topMargin属性

                search_tv_title.setTextColor(search_tv_title.textColors.withAlpha(titleAlpha.toInt()));

//                titleLayoutParams.topMargin = searchLayoutNewWidth.toInt()
//                search_tv_title.layoutParams = titleLayoutParams



                searchLayoutParams.topMargin = searchLayoutNewTopMargin.toInt()
                searchLayoutParams.width =  searchLayoutNewWidth.toInt()
                search_ll_search.layoutParams = searchLayoutParams;


            }

        })

    }


}