package com.lfj.selfstudydemo

import android.app.Application
import android.content.Context

/**
 * @author
 * @date
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        context = this
    }


    companion object {
        lateinit var context: Context
    }
}