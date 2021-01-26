package com.lfj.selfstudydemo

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.lfj.selfstudydemo.activity.NewDetailActivity
import com.lfj.selfstudydemo.appbar.AppBarLayoutActivity
import com.lfj.selfstudydemo.aroute.RouterActivity
import com.lfj.selfstudydemo.coroutine.YoudaoViewModel
import com.lfj.selfstudydemo.diffUtil.DiffActivity
import com.lfj.selfstudydemo.jingdongTop.JingDongTopActivity
import com.lfj.selfstudydemo.layoutmanager.PathLayoutManagerActivity
import com.lfj.selfstudydemo.map.ThirdMapActivity
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.util.GlobalUtil
import com.lfj.selfstudydemo.scroll.ScrollIndexActivity
import com.lfj.selfstudydemo.secondList.SecondRecyclerActivity
import com.lfj.selfstudydemo.webview.WebViewActivity
import com.lfj.selfstudydemo.ybehavior.BehaviorListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val viewModel:YoudaoViewModel = YoudaoViewModel()

    override fun layoutView(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
       var myActivityLauncher = registerForActivityResult(MyActivityResultContract()) {
            Yr.toast("回传数据$it")
        }


        GlobalUtil.setOnClickListener(
            activityMvvM,
            nestedScroll,
            kaiyan,
            jingdongTop,
            behavior,
            appbarLayout,
            secondRecycler,
            webView,
            DatePick,
            toMap,
            Route,
            DiffUtils,
            layoutManager,
            ResultLauncher
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
                    startActivity(Intent(activity, AppBarLayoutActivity::class.java))
                }
                secondRecycler -> {
                    startActivity(Intent(activity, SecondRecyclerActivity::class.java))
                }
                webView -> {
                    startActivity(Intent(activity, WebViewActivity::class.java))
                }
                DatePick -> {
                    startActivity(Intent(activity, DatePickActivity::class.java))
                }
                toMap -> {
                    startActivity(Intent(activity, ThirdMapActivity::class.java))
                }
                Route -> {
                    startActivity(Intent(activity, RouterActivity::class.java))
                }
                DiffUtils -> {
                    startActivity(Intent(activity, DiffActivity::class.java))
                }
                layoutManager -> {
                    startActivity(Intent(activity, PathLayoutManagerActivity::class.java))

                }
                ResultLauncher -> {
                    myActivityLauncher.launch("主页数据")
                }
            }
        }
        lambdaView.setOnclick {

            viewModel.translate("你好！世界")
        }

        viewModel._translateResult.observe(this, Observer {
            Yr.d("123456")
            Snackbar.make(lambdaView,it, Snackbar.LENGTH_SHORT).show()

        })
    }





    override fun initData() {
    }

}
