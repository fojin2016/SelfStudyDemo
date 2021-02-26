package com.lfj.selfstudydemo.linkage

import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.Utiles
import com.lfj.selfstudydemo.mvvm.BaseActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

class LinkageActivity : BaseActivity() {


    override fun layoutView(): Int = R.layout.activity_linkage

    override fun initUI() {
    }

    override fun initData() {
        var s = Utiles.getJson(this, "category.json")



    }
}