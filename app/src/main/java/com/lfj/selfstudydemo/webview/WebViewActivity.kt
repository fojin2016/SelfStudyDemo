package com.lfj.selfstudydemo.webview

import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.lfj.selfstudydemo.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        initWebSetting()
        webView.loadUrl("https://m.buyer.dola-mall.com")
    }


    /**
     * 设置WebSetting
     */
    private fun initWebSetting() {
        val settings = webView.settings
        val ua = settings.userAgentString
        settings.setUserAgentString(ua + "com.jhcms.android")
        settings.javaScriptEnabled = true
        settings.allowFileAccess
        settings.databaseEnabled
        settings.setGeolocationEnabled(true)
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.textZoom = 100
        settings.cacheMode = WebSettings.LOAD_DEFAULT
//        myJavaScriptInterface =
//            com.egets.takeaways.activity.WebViewActivity.JavaScriptInterface(this)
//        webView.addJavascriptInterface(myJavaScriptInterface, "JHAPP")
    }
}