package problems.leetcode.das.hashing

import problems.Problem

/**
 * Example 5: 1248. Count Number of Nice Subarrays
 *
 * Given an array of positive integers nums and an integer k.
 * Find the number of subarrays with exactly k odd numbers in them.
 *
 * For example, given nums = [1, 1, 2, 1, 1], k = 3, the answer is 2.
 * The subarrays with 3 odd numbers in them are [1, 1, 2, 1] and [1, 2, 1, 1].
 */
class CountingExample5 : Problem {
    override fun execute() {
        val nums = intArrayOf(1,1,2,1,1)
        val k = 3

        println("Input: ${nums.contentToString()}")
        println("Number Arrays: ${findArraysWithKOddNumbers(nums, k)}")

    }

    /**
     * The interesting part is that a solution is found without using
     * a map
     */
    private fun findArraysWithKOddNumbers(nums: IntArray, k: Int) : Int{
        var numberArrays = 0
        var start = 0
        var oddNumbers = 0

        for (i in nums.indices) {
            val isOdd = (nums[i] % 2) != 0
            println("-> i=$i num=${nums[i]} isOdd: $isOdd}")
            if (isOdd) {
                oddNumbers++
            }

            if (oddNumbers == k) {
                println("-> array identified!")

                // We have identified a valid array. It's time to move to indexes
                numberArrays++

                // If the old number was odd, then decrement the oddNumbers
                if (nums[start] % 2 != 0) {
                    oddNumbers--
                }
                start++
            }
        }

        return numberArrays
    }
}
