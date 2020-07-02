package com.lfj.selfstudydemo

import androidx.fragment.app.FragmentManager
import com.gyf.immersionbar.ImmersionBar
import com.lfj.selfstudydemo.fragment.HomeFragment
import com.lfj.selfstudydemo.mvvm.BaseActivity

class KaiYanMainActivity : BaseActivity() {


    protected val fragmentManger: FragmentManager by lazy {
        supportFragmentManager
    }

    override fun layoutView(): Int {
        return R.layout.activity_kai_yan_main
    }

    override fun initUI() {

        ImmersionBar.with(this)
            .transparentStatusBar()  //透明状态栏，不写默认透明色
            .autoStatusBarDarkModeEnable(true, 0.2f)
            .fitsSystemWindows(true).init()

        fragmentManger.beginTransaction().apply {
                add(R.id.homeActivityFragContainer,HomeFragment()).commit()
        }
    }

    override fun initData() {
    }
}