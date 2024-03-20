package problems.leetcode.das.arraysnstrings.slidingwindow

import problems.Problem

/**
 * Example 1: Given an array of positive integers nums and an
 * integer k, find the length of the longest subarray whose
 * sum is less than or equal to k.
 *
 * This is the problem we have been talking about above.
 * We will now formally solve it.
 */
class Example1 : Problem {
    override fun execute() {
        val k = 8
        val numbers : IntArray = intArrayOf(3, 1, 2, 7, 4, 2, 1, 1, 5)
        val answer = findLength(numbers, k)
        println("Numbers: ${numbers.contentToString()} K: $k")
        println("Max Length: $answer")
    }

    private fun findLength(nums: IntArray, k: Int): Int {

        var left = 0
        var right = 0
        var sum = 0
        var answer = 0

        for(index in nums.indices) {
            sum += nums[index]
            while (sum > k) {
                sum -= nums[left]
                left++
            }
            answer = Math.max(answer, right - left + 1)
            right++
        }

        return answer
    }
}