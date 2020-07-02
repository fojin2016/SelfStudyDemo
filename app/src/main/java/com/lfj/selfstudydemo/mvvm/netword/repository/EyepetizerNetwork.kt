package com.lfj.selfstudydemo.mvvm.netword.repository

import com.lfj.selfstudydemo.mvvm.netword.ServiceCreator
import com.lfj.selfstudydemo.mvvm.netword.VideoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author
 * @date
 */
class EyepetizerNetwork {


    private val videoService = ServiceCreator.create(VideoService::class.java)


    suspend fun fetchVideoBeanForClient(videoId: Long) = videoService.getVideoBeanForClient(videoId).await()

    suspend fun fetchVideoRelated(videoId: Long) = videoService.getVideoRelated(videoId).await()

    suspend fun fetchVideoReplies(url: String) = videoService.getVideoReplies(url).await()


    /**
     * 对报错拦截
     */
//    private suspend fun <T> Call<T>.await(): T {
//        return suspendCoroutine { continuation ->
//            enqueue(object : Callback<T> {
//                override fun onFailure(call: Call<T>, t: Throwable) {
//                    continuation.resumeWithException(t)
//                }
//
//                override fun onResponse(call: Call<T>, response: Response<T>) {
//                    val body = response.body()
//                    if (body != null) continuation.resume(body)
//                    else continuation.resumeWithException(RuntimeException("response body is null"))
//                }
//            })
//        }
//    }

    companion object {

        private var network: EyepetizerNetwork? = null

        fun getInstance(): EyepetizerNetwork {
            if (network == null) {
                synchronized(EyepetizerNetwork::class.java) {
                    if (network == null) {
                        network =
                            EyepetizerNetwork()
                    }
                }
            }
            return network!!
        }
    }

}