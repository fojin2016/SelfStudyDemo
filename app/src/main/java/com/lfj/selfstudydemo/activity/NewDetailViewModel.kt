package com.lfj.selfstudydemo.activity

import androidx.lifecycle.*
import com.lfj.selfstudydemo.Yr
import com.lfj.selfstudydemo.mvvm.netword.VideoService
import com.lfj.selfstudydemo.mvvm.netword.bean.VideoDetail
import com.lfj.selfstudydemo.mvvm.netword.repository.VideoRepository
import java.lang.Exception

/**
 * @author
 * @date
 */
class NewDetailViewModel(repository: VideoRepository) : ViewModel() {

    var videoId: Long = 198611L

    private var videoDetailLiveData_ = MutableLiveData<RequestParam>()

    private var repliesAndRepliesLiveData_ = MutableLiveData<RequestParam>()

    var videoInfoData: NewDetailActivity.VideoInfo? = null



    val videoDetailLiveData = Transformations.switchMap(videoDetailLiveData_){

        liveData {

            val result = try {
                val videoDetail = repository.requestVideoDetail(it.videoId, it.repliesUrl)
                Result.success(videoDetail)
            }catch (e:Exception){
                Result.failure<VideoDetail>(e)
            }
            emit(result)
        }
    }



    fun onRefresh() {

        if (videoInfoData == null) {
            videoDetailLiveData_.value =
                RequestParam(videoId, "${VideoService.VIDEO_REPLIES_URL}$videoId")
        } else {
            repliesAndRepliesLiveData_.value = RequestParam(
                videoInfoData?.videoId ?: 0L,
                "${VideoService.VIDEO_REPLIES_URL}${videoInfoData?.videoId ?: 0L}"
            )
        }
    }

    //内部类
    inner class RequestParam(val videoId: Long, val repliesUrl: String)

}