package com.lfj.selfstudydemo

import com.lfj.selfstudydemo.mvvm.BaseActivity
import kotlinx.android.synthetic.main.activity_date_pick.*

class DatePickActivity : BaseActivity() {

    override fun layoutView(): Int {
        return R.layout.activity_date_pick
    }

    override fun initUI() {
    }

    override fun initData() {
        Utiles.getNumberPicker(datePicker)
    }


}