package com.jonl.memdogs.data

import com.jonl.memdogs.data.model.DogList
import com.jonl.memdogs.data.model.RandomDog
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NetworkRepositoryTest {

    private lateinit var repository: NetworkRepository

    @Before
    fun setUp() {
        repository = NetworkRepository(FakeNetworkService())
    }

    @Test
    fun getDogList() = runTest {
        val result = repository.dogList.first()
        assertEquals(result.status, "success")
        assertEquals(result.dogList.size, 2)
        assertEquals(result.dogList.keys.first(), "dobermann")
    }

    @Test
    fun getRandomDog() = runTest {
        val result = repository.randomDog.first()
        assertEquals(result, "https://example.com/dog.jpg")
    }
}


class FakeNetworkService: NetworkService {
    override suspend fun getAllDogs(): DogList {
        return DogList(
            status = "success",
            dogList = mapOf(
                Pair("dobermann", listOf("one", "two")),
                Pair("manchester", emptyList()),
            ),
        )
    }

    override suspend fun getRandomDog(): RandomDog {
        return RandomDog(
            status = "success",
            imageUri = "https://example.com/dog.jpg",
        )
    }
}