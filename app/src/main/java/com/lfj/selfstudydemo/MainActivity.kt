package com.lfj.selfstudydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lfj.selfstudydemo.scroll.ScrollIndexActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nestedScroll.setOnClickListener {
            startActivity(Intent(this, ScrollIndexActivity::class.java))
        }
    }
}
