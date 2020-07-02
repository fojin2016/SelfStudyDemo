package com.lfj.selfstudydemo

import android.content.Intent
import android.view.View
import com.lfj.selfstudydemo.activity.NewDetailActivity
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.scroll.ScrollIndexActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun layoutView(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {

        nestedScroll.setOnClickListener {
            startActivity(Intent(this, ScrollIndexActivity::class.java))
        }
        activityMvvM.setOnClickListener {
            startActivity(Intent(this, NewDetailActivity::class.java))
        }
    }


    override fun initData() {
    }

}
