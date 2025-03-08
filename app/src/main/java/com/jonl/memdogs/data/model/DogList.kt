package com.jonl.memdogs.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogList(
    @SerialName("message")
    val dogList: Map<String, List<String>>,
    @SerialName("status")
    val status: String
)