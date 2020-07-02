package com.lfj.selfstudydemo.weight

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * @author
 * @date
 */
class TabEntity(var title: String, var select: Int = 0, var unselect: Int =0) : CustomTabEntity {


    override fun getTabUnselectedIcon() = unselect

    override fun getTabSelectedIcon() = select

    override fun getTabTitle() = title
}