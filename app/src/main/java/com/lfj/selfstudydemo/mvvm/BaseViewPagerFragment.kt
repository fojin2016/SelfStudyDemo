package com.lfj.selfstudydemo.mvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.lfj.selfstudydemo.R

/**
 * @author
 * @date
 */
abstract class BaseViewPagerFragment : Fragment() {


    protected var viewPager: ViewPager2? = null
    protected var tabLayout: CommonTabLayout? = null

    /**
     * ViewPager的适配器
     */
    protected val adapter: VpAdapter by lazy {
        VpAdapter(activity!!).apply {
            addFragment(
                createFragments
            )
        }
    }

    /**
     *  ViewPager 缓存Fragment的个数
     */
    var offscreenPageLimit = 1

    /**
     * Fragment中inflate出来的布局。
     */
    protected var rootView: View? = null

    //tab
    abstract val createTitles: ArrayList<CustomTabEntity>

    // fragment
    abstract val createFragments: Array<Fragment>

    /**
     *  ViewPager的监听
     */
    protected var pageChangeCallback: PageChangeCallback? = null

    /**
     * 在Fragment基类中获取通用的控件，会将传入的View实例原封不动返回。
     * @param view Fragment中inflate出来的View实例。
     * @return  Fragment中inflate出来的View实例原封不动返回。
     */
    fun onCreateView(view: View): View {
        rootView = view
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpViews()
    }


    open fun setUpViews() {

        initViewPager()
    }
    override fun onDestroy() {
        super.onDestroy()
        pageChangeCallback?.run { viewPager?.unregisterOnPageChangeCallback(this) }
        pageChangeCallback = null
    }

    protected fun initViewPager() {
        viewPager = rootView?.findViewById(R.id.viewPager)
        tabLayout = rootView?.findViewById(R.id.tabLayout)

        viewPager?.offscreenPageLimit = offscreenPageLimit

        viewPager?.adapter = adapter
        tabLayout?.setTabData(createTitles)
        tabLayout?.setOnTabSelectListener(object : OnTabSelectListener {

            override fun onTabSelect(position: Int) {
                viewPager?.currentItem = position
            }

            override fun onTabReselect(position: Int) {

            }
        })
        pageChangeCallback = PageChangeCallback()
        viewPager?.registerOnPageChangeCallback(pageChangeCallback!!)
    }


    inner class PageChangeCallback : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            tabLayout?.currentTab = position
        }
    }

    inner class VpAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {


        private val fragments = mutableListOf<Fragment>()


        fun addFragment(fragment: Array<Fragment>) {
            fragments.addAll(fragment)
        }

        override fun getItemCount() = fragments.size

        override fun createFragment(position: Int) = fragments[position]

    }


}