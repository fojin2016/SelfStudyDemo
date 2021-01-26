package com.lfj.selfstudydemo.coroutine

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @description
 * @author LFJ
 * @date   2021/1/26 10:13
 */

interface TranslateApiService {
    @FormUrlEncoded
    @POST("translate?doctype=json")
    suspend fun translate(@Field("i") i: String): Result
}


data class Result(
    val type: String,
    val elapsedTime: Int,
    val translateResult: List<List<TranslateResult>>
) {
    data class TranslateResult(
        val src: String,
        val tgt: String
    )
}

object TranslateApi {
    val retrofitService:TranslateApiService by lazy {
        retrofit.create(TranslateApiService::class.java)
    }
}