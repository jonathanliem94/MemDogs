package com.jonl.memdogs.data

import com.jonl.memdogs.data.model.DogList
import kotlinx.coroutines.flow.flow

class NetworkRepository (private val service: NetworkService) {

    val dogList = flow<DogList> {
        val result = service.getAllDogs()
        emit(result)
    }

    val randomDog = flow<String> {
        val result = service.getRandomDog().imageUri
        emit(result)
    }
}