package com.jonl.memdogs.util

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Locale

class StringUtilsKtTest {

    @Before
    fun setUp() {
        Locale.setDefault(Locale.US)
    }

    @Test
    fun extractBreedFromStringSubBreed() {
        val input = "https://images.dog.ceo/breeds/terrier-russell/IMG_7632.jpg"
        val result = extractBreedFromString(input)
        assertEquals("terrier-russell", result)
    }

    @Test
    fun extractBreedFromStringBreed() {
        val input = "https://images.dog.ceo/breeds/chow/n02112137_16270.jpg"
        val result = extractBreedFromString(input)
        assertEquals("chow", result)
    }

    @Test
    fun extractBreedFromStringEmpty() {
        val input = ""
        val result = extractBreedFromString(input)
        assertEquals("", result)
    }

    @Test
    fun formatNameSubBreed() {
        val input = "terrier-russell"
        val result = formatName(input)
        assertEquals("Russell Terrier", result)
    }

    @Test
    fun formatNameBreed() {
        val input = "chow"
        val result = formatName(input)
        assertEquals("Chow", result)
    }

    @Test
    fun formatNameSubEmpty() {
        val input = ""
        val result = formatName(input)
        assertEquals("", result)
    }
}