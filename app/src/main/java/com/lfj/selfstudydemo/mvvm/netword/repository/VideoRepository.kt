package com.lfj.selfstudydemo.mvvm.netword.repository

import androidx.lifecycle.ViewModelProvider
import com.lfj.selfstudydemo.mvvm.netword.ServiceCreator
import com.lfj.selfstudydemo.mvvm.netword.VideoService
import com.lfj.selfstudydemo.mvvm.netword.bean.VideoDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.await

/**
 * @author
 * @date
 */
class VideoRepository(private val network: EyepetizerNetwork): ViewModelProvider.NewInstanceFactory() {




    //一次请求 请求3个接口
    suspend fun requestVideoDetail(videoId: Long, repliesUrl: String) = withContext(Dispatchers.IO) {

            coroutineScope {

//                val deferredVideoRelated = async { ServiceCreator.create(VideoService::class.java).getVideoRelated(videoId).await() }
                val deferredVideoRelated = async { network.fetchVideoRelated(videoId) }
                val deferredVideoReplies = async { network.fetchVideoReplies(repliesUrl) }
                val deferredVideoBeanForClient = async { network.fetchVideoBeanForClient(videoId) }
                val videoBeanForClient = deferredVideoBeanForClient.await()
                val videoRelated = deferredVideoRelated.await()
                val videoReplies = deferredVideoReplies.await()
                val videoDetail = VideoDetail(videoBeanForClient, videoRelated, videoReplies)


                videoDetail

            }

        }


    companion object {

        private var repository: VideoRepository? = null

        fun getInstance(network: EyepetizerNetwork): VideoRepository {
            if (repository == null) {
                synchronized(VideoRepository::class.java) {
                    if (repository == null) {
                        repository = VideoRepository(network)
                    }
                }
            }

            return repository!!
        }
    }

}