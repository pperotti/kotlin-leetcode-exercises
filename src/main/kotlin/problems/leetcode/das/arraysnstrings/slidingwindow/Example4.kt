package problems.leetcode.das.arraysnstrings.slidingwindow

import problems.Problem

/**
 * Example 4: Given an integer array nums and an integer k,
 * find the sum of the subarray with the largest sum whose
 * length is k.
 */
class Example4 : Problem {
    override fun execute() {
        val nums = intArrayOf(-3, -1, 4, 12, -8, 5, 6)
        val k = 4
        val answer = findBestSubarray(nums, k)
        println("Numbers: ${nums.contentToString()} K: $k")
        println("Max Length: $answer")
    }

    private fun findBestSubarray(nums: IntArray, k: Int) : Int {
        var curr = 0

        for (i in 0..k-1) {
            curr += nums[i]
        }

        var ans = curr
        for (i in k .. nums.size-1) {
            curr += nums[i] - nums[i-k]
            ans = Math.max(ans, curr)
        }
        return ans
    }
}