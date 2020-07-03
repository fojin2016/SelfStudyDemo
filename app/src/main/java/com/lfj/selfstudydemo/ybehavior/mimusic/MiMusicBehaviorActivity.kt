package com.lfj.selfstudydemo.ybehavior.mimusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyf.immersionbar.ImmersionBar
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.fragment.HomeFragment
import com.lfj.selfstudydemo.scroll.ScrollAdapter
import kotlinx.android.synthetic.main.out_side_scroll.*

class MiMusicBehaviorActivity : AppCompatActivity() {


    protected val fragmentManger: FragmentManager by lazy {
        supportFragmentManager
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_music_behavior)

        ImmersionBar.with(this)

            .statusBarColor(R.color.statuscolor)
            .statusBarColorTransform(R.color.statuscolor)  //状态栏变色后的颜色
            .fitsSystemWindows(true).init()


        scrollViewIn.layoutManager = LinearLayoutManager(this)


        var data = mutableListOf<String>()

        for (index in 0..100) {
            data.add(index, "数据$index")
        }

        scrollViewIn.adapter = ScrollAdapter(data)

        scrollViewIn.scrollToPosition(0)

    }
}