package com.lfj.selfstudydemo.mvvm

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.util.ActivityCollector
import java.lang.ref.WeakReference

/**
 * @author
 * @date
 */
abstract class BaseActivity : AppCompatActivity() {


    /**
     * 判断当前Activity是否在前台。
     */
    protected var isActive: Boolean = false

    /**
     * 当前Activity的实例。
     */
    protected var activity: Activity? = null

    /** 当前Activity的弱引用，防止内存泄露  */
    private var activityWR: WeakReference<Activity>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局
        setContentView(layoutView())

        activity = this
        activityWR = WeakReference(activity!!)
        ActivityCollector.pushTask(activityWR)

        //初始化控件
        initUI()
        //设置数据
        initData()
    }


    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeTask(activityWR)
    }

    protected abstract fun layoutView(): Int

    protected abstract fun initUI()

    protected abstract fun initData()



}