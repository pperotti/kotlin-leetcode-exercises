package problems.leetcode.das.arraysnstrings.slidingwindow

/**
 * URL:
 *
 * Example 1: Given an array of positive integers 'nums' and an
 * integer k, find the length of the longest subarray whose
 * sum is less than or equal to k.
 *
 * This is the problem we have been talking about above.
 * We will now formally solve it.
 */
class SlidingWindowExample1 {

    /*
    Given a subarray starting at left and ending at right,
    the length is right - left + 1. As mentioned before,
    this algorithm has a time complexity of O(n) since all
    work done inside the for loop is amortized O(1), where n
    is the length of nums. The space complexity is constant
    because we are only using 3 integer variables.
     */
    fun findLength(nums: IntArray, k: Int): Int {

        var left = 0
        var right = 0
        var sum = 0
        var answer = 0

        for (index in nums.indices) {
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