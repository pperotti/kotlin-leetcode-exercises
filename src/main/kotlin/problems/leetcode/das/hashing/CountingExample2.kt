package problems.leetcode.das.hashing

import problems.Problem

/**
 * Example 2: 2248. Intersection of Multiple Arrays
 *
 * Given a 2D array nums that contains n arrays of distinct integers,
 * return a sorted array containing all the numbers that appear in all n arrays.
 *
 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]],
 * return [3, 4]. 3 and 4 are the only numbers that are in all arrays.
 */
class CountingExample2 : Problem {
    override fun execute() {
        val nums = arrayOf<IntArray>(
            intArrayOf(3,1,2,4,5),
            intArrayOf(1,2,3,4),
            intArrayOf(3,4,5,6)
        )
        println("Input: ${nums.contentDeepToString()}")
        println("Common Numbers: ${findCommonNumbers(nums).contentToString()}")
    }

    private fun findCommonNumbers(nums: Array<IntArray>) : IntArray {
        val countMap = mutableMapOf<Int, Int>()

        // Iterate over nums to fill a map with the counts
        for (intArray in nums) {
            intArray.forEach { num ->
                val value = countMap.getOrDefault(num, 0) + 1
                countMap[num] = value
            }
        }

        // Iterate over the map to fill the result's array with only those
        // with counts = #rows
        return countMap.filterValues { it == 3 }.keys.toIntArray()
    }
}