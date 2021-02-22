package com.lfj.selfstudydemo.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.activity_google_translate.*

class GoogleTranslateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_translate)

        翻译.setOnClickListener {
            TranslateUtil().translate(this,"auto","km",edString.text.toString(),object :TranslateCallback{
                override fun onTranslateDone(result: String) {
                    tvShow.text = result
                }

            })
        }
    }
}