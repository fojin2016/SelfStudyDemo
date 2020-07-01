package com.lfj.selfstudydemo.scroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.activity_scroll_index.*
import kotlinx.android.synthetic.main.out_side_scroll.*

class ScrollIndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_index)
        initUI()

        eleme.setOnClickListener { startActivity(Intent(this, ElemeScrollActivity::class.java)) }
    }


    private fun initUI() {

        scrollViewIn.layoutManager = LinearLayoutManager(this)


        var data = mutableListOf<String>()

        for (index in 0..100) {
            data.add(index, "数据$index")
        }

        scrollViewIn.adapter = ScrollAdapter(data)

        scrollViewIn.scrollToPosition(50)
    }

}
