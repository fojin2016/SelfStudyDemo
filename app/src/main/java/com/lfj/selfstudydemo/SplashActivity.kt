package com.lfj.selfstudydemo

import android.Manifest
import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.core.content.edit
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.util.GlobalUtil
import com.permissionx.guolindev.PermissionX
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *   简单的设计协程的用法
 *
 *    延迟执行
 *
 */
class SplashActivity : BaseActivity() {


    //这是最常用的用于启动协程的方式，它最终返回一个Job类型的对象，这个Job类型的对象实际上是一个接口，它包涵了许多我们常用的方法

    private val job by lazy { Job() }

    private val splashDuration = 3 * 1000L

    // 懒加载 --- 用时生成
    private val alphaAnimation by lazy {
        AlphaAnimation(0.5f, 1.0f).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    private val scaleAnimation by lazy {
        ScaleAnimation(
            1f,
            1.05f,
            1f,
            1.05f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        ).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    override fun layoutView(): Int {
        return R.layout.activity_splash
    }

    override fun initUI() {
    }

    override fun initData() {

        requestWriteExternalStoragePermission()
    }


    private fun requestWriteExternalStoragePermission() {
        PermissionX.init(this@SplashActivity)
            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .onExplainRequestReason { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_picture_processing)
                scope.showRequestReasonDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.ok),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .onForwardToSettings { scope, deniedList ->
                val message = GlobalUtil.getString(R.string.request_permission_picture_processing)
                scope.showForwardToSettingsDialog(
                    deniedList,
                    message,
                    GlobalUtil.getString(R.string.settings),
                    GlobalUtil.getString(R.string.cancel)
                )
            }
            .request { allGranted, grantedList, deniedList ->

                ivSplashPicture.startAnimation(scaleAnimation)

                CoroutineScope(job).launch {
                    delay(splashDuration)
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
    }


    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    /**
     * 修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
     */
    companion object {
        /**
         * 是否首次进入APP应用
         */
        var isFirstEntryApp: Boolean
            get() = GlobalUtil.sharedPreferences.getBoolean("is_first_entry_app", true)
            set(value) = GlobalUtil.sharedPreferences.edit {
                putBoolean(
                    "is_first_entry_app",
                    value
                )
            }

    }
}