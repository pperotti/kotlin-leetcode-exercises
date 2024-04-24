package problems.leetcode.das.hashing

import problems.Problem

/**
 * Example 4: 560. Subarray Sum Equals K
 *
 * Given an integer array nums and an integer k, find the number
 * of subarrays whose sum is equal to k.
 */
class CountingExample4 : Problem {
    override fun execute() {
        val nums = intArrayOf(1,2,1,2,1)
        val k = 3
        println("Input: ${nums.contentToString()}")
        println("Number of Subarrays: ${findNumberOfSubArraysWIthExactValue(nums, k)}")
    }

    private fun findNumberOfSubArraysWIthExactValue(nums: IntArray, k: Int) : Int {
        var start = 0
        var accum = 0
        var answer = 0
        for (i in nums.indices) {
            val number = nums[i]
            println("---------> i: $i / number: $number / accum: $accum / answer: $answer")
            var repeat = true
            do {
                val sum = accum + number
                println("- sum: $sum")
                if (sum == k) {
                    answer++

                    // We do not take into account the current number
                    //accum = 0
                    //start = i + 1

                    // We take into account the current number
                    accum = number
                    start = i

                    repeat = false
                } else if (sum > k) { // Move start to the right, Update accum
                    start++
                    accum -= nums[start]
                } else { //sum < k
                    accum += number
                    repeat = false
                }
                println("- after processing accum: $accum / start=$start / answer: $answer")
            } while (repeat)
        }
        return answer
    }


}