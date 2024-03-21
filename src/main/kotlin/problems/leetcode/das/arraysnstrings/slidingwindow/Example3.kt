package problems.leetcode.das.arraysnstrings.slidingwindow

import problems.Problem

/**
 * Example 3: 713. Subarray Product Less Than K.
 *
 * Given an array of positive integers nums and an integer k,
 * return the number of subarrays where the product of all
 * the elements in the subarray is strictly less than k.
 *
 * For example, given the input:
 * nums = [10, 5, 2, 6], k = 100,
 * the answer is 8.
 *
 * The subarrays with products less than k are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 */
class Example3 : Problem {
    override fun execute() {
        val nums = intArrayOf(10, 5, 2, 6)
        val k = 100
        val answer = numSubarrayProductLessThanK(nums, k)
        println("Numbers: ${nums.contentToString()} K: $k")
        println("Max Length: $answer")
    }

    /*
    The work done in each loop iteration is AMORTIZED CONSTANT
    so this algorithm has a runtime of O(n) where n is a length
    of 'nums'. We have O(1) for space usage.
     */
    private fun numSubarrayProductLessThanK(nums: IntArray, k: Int) : Int {
        if (k <= 1) {
            return 0
        }

        var ans = 0
        var left = 0
        var curr = 1; // Temp variable to hold product value

        for (right in 0 .. nums.size-1) {
            curr *= nums[right]
            while (curr >= k) {
                curr /= nums[left]
                left++
            }
            ans += right - left + 1
        }

        return ans
    }
}