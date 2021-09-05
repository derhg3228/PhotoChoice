package com.example.photochanger.data.model

//Модель всех медиа файлов профиля
data class MediaModelDto (
    val data: List<MediaModelIdDto>
)

//Модель для получения id медиа ресурса
data class MediaModelIdDto (
    val id: String
)