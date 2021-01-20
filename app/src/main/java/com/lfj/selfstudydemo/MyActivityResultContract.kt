package com.lfj.selfstudydemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.lfj.selfstudydemo.ResultContract.SecondActivity

/**
 * @description
 * @author LFJ
 * @date   2021/1/12 15:19
 */
class MyActivityResultContract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String?): Intent {

        return Intent(context, SecondActivity::class.java).apply {
            putExtra("name", input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        var data = intent?.getStringExtra("name")
        return if (resultCode == Activity.RESULT_OK && data != null) {
            data
        } else {
            null
        }
    }
}