package problems.leetcode.das.arraysnstrings.slidingwindow

/**
 * Example 4: Given an integer array nums and an integer k,
 * find the sum of the subarray with the largest sum whose
 * length is k.
 */
class SlidingWindowExample4 {

    /**
     * Find the best subarray where the sum of its elements is less than 'k'.
     * @param nums Input array of ints to evaluate
     * @param k Max value for the sum.
     * @return
     */
    fun findBestSubarray(nums: IntArray, k: Int): Int {
        var curr = 0

        for (i in 0..k - 1) {
            curr += nums[i]
        }

        var ans = curr
        for (i in k..nums.size - 1) {
            curr += nums[i] - nums[i - k]
            ans = Math.max(ans, curr)
        }
        return ans
    }
}