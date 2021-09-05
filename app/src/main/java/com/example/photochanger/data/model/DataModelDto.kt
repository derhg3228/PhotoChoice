package com.example.photochanger.data.model

//Модель для получения Id
data class DataModelDto(
    val data: List<ProfileModelDto>
)

//Вспомогательный класс для получения Id
data class ProfileModelDto(
    val id: String,
    val name: String
)