package utils

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