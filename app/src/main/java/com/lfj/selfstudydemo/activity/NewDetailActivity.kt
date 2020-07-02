package com.lfj.selfstudydemo.activity

import android.os.Parcelable
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lfj.selfstudydemo.R
import com.lfj.selfstudydemo.Yr
import com.lfj.selfstudydemo.mvvm.BaseActivity
import com.lfj.selfstudydemo.mvvm.netword.bean.Author
import com.lfj.selfstudydemo.mvvm.netword.bean.Consumption
import com.lfj.selfstudydemo.mvvm.netword.bean.Cover
import com.lfj.selfstudydemo.mvvm.netword.bean.WebUrl
import com.lfj.selfstudydemo.mvvm.netword.repository.EyepetizerNetwork
import com.lfj.selfstudydemo.mvvm.netword.repository.VideoRepository
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_new_deyail.*

class NewDetailActivity : BaseActivity() {


    private val viewModel by lazy {
        ViewModelProvider(
            this, NewDetailViewModelFactory(
                VideoRepository(EyepetizerNetwork.getInstance())
            )
        ).get(NewDetailViewModel::class.java)
    }

    override fun layoutView(): Int {
        return R.layout.activity_new_deyail
    }

    override fun initUI() {

    }

    override fun initData() {
        observe()
        startVideoPlayer()
        viewModel.onRefresh()
    }




    private fun startVideoPlayer() {
        viewModel.videoInfoData?.run {
//            ivBlurredBg.load(cover.blurred)
//            tvReplyCount.text = consumption.replyCount.toString()
            videoPlayer.startPlay()
        }
    }


    private fun observe() {
        //刷新，视频信息+相关推荐+评论

            viewModel.videoDetailLiveData.observe(this, Observer { result ->
                Yr.d(result)
                val response = result.getOrNull()
                if (response == null) {
                    return@Observer
                }
                response.videoBeanForClient?.run {
                    viewModel.videoInfoData = VideoInfo(id, playUrl, title, description, category, library, consumption, cover, author, webUrl)
                    startVideoPlayer()
//                    relatedAdapter.bindVideoInfo(viewModel.videoInfoData)
                }
            })


    }


    private fun GSYVideoPlayer.startPlay() {
        viewModel.videoInfoData?.let {
            //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
//            fullscreenButton.setOnClickListener { showFull() }
            //防止错位设置
            playTag = ""
            //音频焦点冲突时是否释放
            isReleaseWhenLossAudio = false
            //增加封面
            val imageView = ImageView(this@NewDetailActivity)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
//            imageView.load(it.cover.detail)
            thumbImageView = imageView
//            thumbImageView.setOnClickListener { switchTitleBarVisible() }
            //是否开启自动旋转
            isRotateViewAuto = false
            //是否需要全屏锁定屏幕功能
            isNeedLockFull = true
            //是否可以滑动调整
            setIsTouchWiget(true)
            //设置触摸显示控制ui的消失时间
            dismissControlTime = 5000
            //设置播放过程中的回调
//            setVideoAllCallBack(VideoCallPlayBack())
            //设置播放URL
            setUp(it.playUrl, false, it.title)
            //开始播放
            startPlayLogic()
        }
    }

    @Parcelize
    data class VideoInfo(
        val videoId: Long,
        val playUrl: String,
        val title: String,
        val description: String,
        val category: String,
        val library: String,
        val consumption: Consumption,
        val cover: Cover,
        val author: Author?,
        val webUrl: WebUrl
    ) : Parcelable
}