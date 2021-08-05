package com.ijays.composeit.anim

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by ijays on 2021/3/5.
 */
class AnimViewModel : ViewModel() {
    var totalAnimTime = 0

    var currentAnimTime: Int by mutableStateOf(value = 0)

    fun setCountdownTime(time: Int) {
        totalAnimTime = time

        viewModelScope.launch(Dispatchers.Main) {
            val tickSeconds = 0
            for (second in totalAnimTime downTo tickSeconds) {
                currentAnimTime = totalAnimTime - second
                delay(1000L)
            }
        }
    }
}