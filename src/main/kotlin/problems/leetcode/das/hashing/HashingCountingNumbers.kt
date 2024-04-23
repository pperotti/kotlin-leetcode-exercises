package problems.leetcode.das.hashing

import problems.Problem

/**
 * Given an integer array arr, count how many elements x there are,
 * such that x + 1 is also in arr. If there are duplicates in arr,
 * count them separately.
 */
class HashingCountingNumbers : Problem {
    override fun execute() {
        //val nums = intArrayOf(1,1,3,3,5,5,7,7)
        //val nums = intArrayOf(1,2,3)
        val nums = intArrayOf(1,1,2,2)
        println("Input: ${nums.contentToString()}")
        println("Element Count: ${countElements(nums)}")
    }

    fun countElements(nums: IntArray): Int {
        var count = 0
        val expectedValues = mutableListOf<Int>()

        // Create set with pre-processed info
        nums.forEach {num ->
            expectedValues.add(num + 1)
        }

        // Iterate over the array again
        expectedValues.forEach { value ->
            if (nums.contains(value)) {
                count++
            }
        }

        return count
    }
}