package com.jonl.memdogs.util

import java.util.Locale

fun extractBreedFromString(input: String): String {
    val pathSegments = input.split("/")
    // Assuming the breed is always the second to last segment
    return if (pathSegments.size >= 2) {
        pathSegments[pathSegments.size - 2]
    } else {
        ""
    }
}

fun formatName(name: String): String {
    val nameSegments = name.split("-")
    return nameSegments.asReversed().joinToString(separator = " ") { seg ->
        seg.replaceFirstChar {
            it.uppercase(Locale.getDefault())
        }
    }

}