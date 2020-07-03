package com.lfj.selfstudydemo.ybehavior

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.ybehavior.mimusic.MiMusicBehaviorActivity
import kotlinx.android.synthetic.main.activity_behavior_list.*

class BehaviorListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_behavior_list)

        xiaomi.setOnClickListener {
            startActivity(Intent(this, MiMusicBehaviorActivity::class.java))
        }
    }
}