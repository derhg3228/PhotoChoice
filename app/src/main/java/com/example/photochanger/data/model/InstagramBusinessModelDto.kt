package com.example.photochanger.data.model

//Модель для получения businessId
data class InstagramBusinessModelDto(
    val instagram_business_account: InstagramBusinessModelIdDto
)

//Вспомогательная модель для получения businessId
data class InstagramBusinessModelIdDto(
    val id: String
)