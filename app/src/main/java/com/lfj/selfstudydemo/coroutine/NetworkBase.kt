package com.lfj.selfstudydemo.coroutine

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @description
 * @author LFJ
 * @date   2021/1/26 10:11
 */
private const val BASE_URL="http://fanyi.youdao.com/"

val retrofit  = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()