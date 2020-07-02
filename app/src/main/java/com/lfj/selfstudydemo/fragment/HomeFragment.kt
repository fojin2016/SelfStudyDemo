package com.lfj.selfstudydemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.mvvm.BaseViewPagerFragment
import com.lfj.selfstudydemo.weight.TabEntity

/**
 * @author
 * @date
 */
class HomeFragment : BaseViewPagerFragment() {

    override val createTitles = ArrayList<CustomTabEntity>().apply {
        add(TabEntity("发现"))
        add(TabEntity("推荐"))
        add(TabEntity("日报"))
    }

    override val createFragments:Array<Fragment> = arrayOf(DiscoveryFragment.newInstance(),DiscoveryFragment.newInstance(),DiscoveryFragment.newInstance())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater.inflate(R.layout.fragment_home, container, false))
    }


}