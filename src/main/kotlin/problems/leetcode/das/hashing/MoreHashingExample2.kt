package problems.leetcode.das.hashing

import problems.Problem
import utils.printIntMapContents

/**
 * 2260. Minimum Consecutive Cards to Pick Up
 *
 * Given an integer array cards, find the length of the shortest subarray that contains at least
 * one duplicate. If the array has no duplicates, return -1.
 */
class MoreHashingExample2 : Problem {
    override fun execute() {
        val input = intArrayOf(1,2,6,2,1)
        println("Input: ${input.contentToString()}")
        println("Output: ${minimumConsecutiveCards(input)}")
    }

    private fun minimumConsecutiveCards(cards: IntArray) : Int {
        val cardMap = hashMapOf<Int, MutableList<Int>>()

        // Create the map with indexes
        cards.forEachIndexed { index, c ->
            val indexList = cardMap.getOrDefault(c, mutableListOf())
            indexList.add(index)
            cardMap[c] = indexList
        }

        printIntMapContents(cardMap)

        // Calculate the min length
        var minLength = -1
        cardMap.values.forEach { items ->
            val distance = minDistance(items)
            println("---> distance: $distance")
            if (distance != -1) {
                minLength = if (minLength == -1) {
                    distance
                } else {
                    Math.min(minLength, distance)
                }
            }
        }
        return minLength
    }

    private fun minDistance(list: List<Int>) : Int {
        var minDistance = -1
        if (list.size > 1) {
            list.onEachIndexed { index, i ->
                if (index > 0) {
                    val distance = list[index] - list[index-1]
                    minDistance = if (minDistance == -1) distance else Math.min(minDistance, distance)
                }
            }
        }
        return minDistance
    }
}