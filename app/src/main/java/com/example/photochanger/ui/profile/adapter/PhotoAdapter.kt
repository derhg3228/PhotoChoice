package com.example.photochanger.ui.profile.adapter

import com.example.photochanger.databinding.ItemPhotoCardBinding
import com.example.photochanger.domain.model.PhotoModel
import com.example.photochanger.downloadAndSetImage
import com.livermor.delegateadapter.delegate.ViewBindingDelegateAdapter

class PhotoAdapter :
    ViewBindingDelegateAdapter<PhotoModel, ItemPhotoCardBinding>(ItemPhotoCardBinding::inflate) {
    override fun isForViewType(item: Any) = item is PhotoModel

    override fun PhotoModel.getItemId() = mediaUrl

    override fun ItemPhotoCardBinding.onBind(item: PhotoModel) {
        photo.downloadAndSetImage(item.mediaUrl)
    }
}