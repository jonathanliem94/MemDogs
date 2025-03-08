package com.jonl.memdogs.data

import com.jonl.memdogs.data.model.DogList
import com.jonl.memdogs.data.model.RandomDog
import retrofit2.http.GET

interface NetworkService {

    @GET("breeds/image/random")
    suspend fun getRandomDog(): RandomDog

    @GET("breeds/list/all")
    suspend fun getAllDogs(): DogList

}