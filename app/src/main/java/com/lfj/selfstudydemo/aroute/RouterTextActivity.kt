package com.lfj.selfstudydemo.aroute

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.BaseActivity

@Route(path = "/routess/RouterText")
class RouterTextActivity : BaseActivity() {

    override fun layoutView() = R.layout.activity_router_text

    override fun initUI() {
        ARouter.getInstance().inject(this)
    }

    override fun initData() {
    }
}