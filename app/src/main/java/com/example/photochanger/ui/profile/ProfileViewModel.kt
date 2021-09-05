package com.example.photochanger.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.photochanger.domain.model.PhotoModel
import com.example.photochanger.domain.use_case.MediaUseCase
import com.example.photochanger.ui.common.BaseViewModel
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(
    private val mediaUseCase: MediaUseCase
): BaseViewModel() {

    private val _photoUrls = MutableLiveData<List<PhotoModel>>()

    val photoUrls: LiveData<List<PhotoModel>>
        get() = _photoUrls

    init {
        getUrls()
    }

    private fun getUrls(){
        mediaUseCase.getMedias()
            .subscribeOn(Schedulers.io())
            .subscribe(_photoUrls::postValue) {
                Log.e(it::class.simpleName, it.message.toString())
            }
            .untilCleared()
    }
}