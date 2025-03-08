package com.jonl.memdogs.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomDog(
    @SerialName("message")
    val imageUri: String,
    @SerialName("status")
    val status: String
)
