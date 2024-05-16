package utils

import java.io.File

/**
 * Print the contents in the array along with its size.
 */
fun printContents(solution: IntArray) {
    println("---- Solution ----")
    println("Size: ${solution.size}")
    if (solution.isNotEmpty()) {
        println(solution.contentToString())
    }
}

fun printContents(map: Map<Int, IntArray>) {
    println("Map Content: ")
    map.forEach { (i, ints) ->
        println("$i -> ${ints.contentToString()}")
    }
}

fun readContentsFromFile(): IntArray {
    val contents = mutableListOf<Int>()
    val file = File("src/main/resources/content.txt")
    try {
        val text = file.readText()
        text.forEach {
            if (it == '0') {
                contents.add(0)
            } else {
                contents.add(1)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return contents.toIntArray()
}