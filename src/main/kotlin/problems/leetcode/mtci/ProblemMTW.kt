package problems.leetcode.mtci

import problems.Problem
import kotlin.math.floor

class ProblemMTW : Problem {
    override fun execute() {

        // Given an array, iterate as many times as defined by constant d
        // then reduce the value of the greatest element in the array by 2
        // and sum the value at the end
        val elements = mutableListOf(30,20,25)
        println("Elements: ${elements}")
        val result = calculateMTW(elements, 4)
        println("Elements: ${elements} -> Result: $result")
    }

    private fun calculateMTW(elements: MutableList<Int>, iterations: Int = 1) : Int {

        // Some validations
        if (elements.size == 0 || iterations < 1) {
            return 0
        }

        // Iterate as many times as defined in 'iterations'
        (0 .. iterations).forEach { iteration ->

            // Sort in natural order so I can just pick the biggest number by
            // picking the last element of the list
            elements.sort()

            println("---> before ${elements}")

            // Get the largest number from the list, split the value in half
            // and update current position with the new value
            elements[elements.lastIndex] = floor((elements[elements.lastIndex] / 2).toDouble()).toInt()

            println("---> after ${elements}")
        }

        // Sum all the elements in the array
        var sum = 0
        elements.forEach { sum += it }

        return sum
    }
}