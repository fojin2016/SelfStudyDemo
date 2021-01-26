package com.lfj.selfstudydemo.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lfj.selfstudydemo.Yr
import kotlinx.coroutines.launch

/**
 * @description
 * @author LFJ
 * @date   2021/1/26 10:38
 */
class YoudaoViewModel : ViewModel() {
    private val translateResult: MutableLiveData<String> = MutableLiveData()
     val _translateResult: LiveData<String>
        get() = translateResult

    fun translate(words: String) {
        viewModelScope.launch {
            Yr.d()
            val result = TranslateApi.retrofitService.translate(words)
            translateResult.value = result.translateResult[0][0].tgt
            Yr.d(translateResult.value)
        }
    }
}