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

fun printIntMapContents(map: Map<Int, List<Int>>) {
    println("Map Content: ")
    map.forEach { (i, list) ->
        println("$i -> $list")
    }
}

fun printMapWithCharAndInts(map: Map<Char, Int>) {
    println("Map Content: ")
    map.forEach { (c, int) ->
        println("$c -> $int")
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

fun readIntArrayContentsFromFile(source: String): IntArray {
    val contents = mutableListOf<Int>()
    val sb = StringBuilder()
    val file = File(source)
    try {
        val text = file.readText()
        text.forEach {
            if (it == '[') {
                contents.clear()
            } else if (it == ',' || it == ']') {
                contents.add(sb.toString().toInt())
                sb.clear()
            } else if (it.isDigit() || it == '-') {
                sb.append(it)
            }
            //} else if (it == ']') {
            // We should return here
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return contents.toIntArray()
}