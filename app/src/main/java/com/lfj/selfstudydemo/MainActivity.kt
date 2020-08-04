package com.lfj.selfstudydemo

import android.content.Intent
import android.view.View
import com.lfj.selfstudydemo.activity.NewDetailActivity
import com.lfj.selfstudydemo.appbar.AppBarLayoutActivity
import com.lfj.selfstudydemo.jingdongTop.JingDongTopActivity
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.util.GlobalUtil
import com.lfj.selfstudydemo.scroll.ScrollIndexActivity
import com.lfj.selfstudydemo.secondList.SecondRecyclerActivity
import com.lfj.selfstudydemo.ybehavior.BehaviorListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun layoutView(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {

        GlobalUtil.setOnClickListener(
            activityMvvM,
            nestedScroll,
            kaiyan,
            jingdongTop,
            behavior,
            appbarLayout,
            secondRecycler
        ) {
            when (this) {

                activityMvvM -> {
                    startActivity(Intent(activity, NewDetailActivity::class.java))
                }

                kaiyan -> {
                    startActivity(Intent(activity, KaiYanMainActivity::class.java))
                }

                nestedScroll -> {
                    startActivity(Intent(activity, ScrollIndexActivity::class.java))
                }

                jingdongTop -> {
                    startActivity(Intent(activity, JingDongTopActivity::class.java))
                }

                behavior -> {
                    startActivity(Intent(activity, BehaviorListActivity::class.java))
                }
                appbarLayout -> {
                    startActivity(Intent(activity,AppBarLayoutActivity::class.java))
                }
                secondRecycler ->{
                    startActivity(Intent(activity,SecondRecyclerActivity::class.java))
                }
            }
        }

    }


    override fun initData() {
    }

}
