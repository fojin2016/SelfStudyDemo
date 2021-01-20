package com.lfj.selfstudydemo.ResultContract

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name")

        tvName.text = name

        btnBack.setOnClickListener {
            var intent = Intent().apply {
                putExtra("name", "Hello  word")
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}