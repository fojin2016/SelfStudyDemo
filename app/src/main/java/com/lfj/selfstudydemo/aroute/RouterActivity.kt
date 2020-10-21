package com.lfj.selfstudydemo.aroute

import com.alibaba.android.arouter.launcher.ARouter
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.util.GlobalUtil
import kotlinx.android.synthetic.main.activity_router.*

class RouterActivity : BaseActivity() {

    override fun layoutView() = R.layout.activity_router
    override fun initUI() {
        ARouter.getInstance().inject(this)
    }

    override fun initData() {

        GlobalUtil.setOnClickListener(inPage,outPage) {
            when(this){

                inPage ->{
                    ARouter.getInstance().build("/routess/RouterText").navigation()
                }
                outPage ->{
                    ARouter.getInstance().build("/route/RouterText").navigation()
                }
            }
        }
    }
}