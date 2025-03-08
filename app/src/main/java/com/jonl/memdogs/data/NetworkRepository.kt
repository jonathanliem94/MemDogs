package com.jonl.memdogs.data

import com.jonl.memdogs.data.model.DogList
import com.jonl.memdogs.data.model.RandomDog

class NetworkRepository (private val service: NetworkService) {

    suspend fun getRandomDog(): RandomDog {
        return service.getRandomDog()
    }

    suspend fun getDogList(): DogList {
        return service.getAllDogs()
    }
}