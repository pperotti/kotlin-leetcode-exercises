package problems.leetcode.das.queues

import problems.Problem

/**
 * Longest Continuous Subarray
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
 *
 * Given an array of integers nums and an integer limit, return the size of the longest
 * non-empty subarray such that the absolute difference between any two elements of this
 * subarray is less than or equal to limit.
 */
class QueuesLongestContinuousSubarray : Problem {
    override fun execute() {
        //val nums = intArrayOf(8,2,4,7)
        //val limit = 4
//        val nums = intArrayOf(10,1,2,4,7,2)
//        val limit = 5
        val nums = intArrayOf(2,2,2,4,4,2,5,5,5,5,5,2)
        val limit = 2
        println("Input: ${nums.contentToString()}")
        println("Output: ${longestSubarray(nums, limit)}")
    }

    private fun longestSubarray(nums: IntArray, limit: Int): Int {
        var answer = 0
        var left = 0
        val increasingQueue = ArrayDeque<Int>()
        val decreasingQueue = ArrayDeque<Int>()

        for (right in nums.indices) {

            // Handle Increasing Deque
            while (increasingQueue.isNotEmpty() && increasingQueue.last() > nums[right]) {
                increasingQueue.removeLast()
            }
            increasingQueue.addLast(nums[right])

            // Handle Decreasing Deque
            while (decreasingQueue.isNotEmpty() && decreasingQueue.last() < nums[right]) {
                decreasingQueue.removeLast()
            }
            decreasingQueue.addLast(nums[right])

            // Compare with the limit between first of both queues
            while (getFirstOrElse(decreasingQueue, Int.MIN_VALUE) - getFirstOrElse(increasingQueue, Int.MIN_VALUE) > limit) {
                if (decreasingQueue.isNotEmpty() && decreasingQueue.first() == nums[left]) {
                    decreasingQueue.removeFirst()
                }
                if (increasingQueue.isNotEmpty() && increasingQueue.first() == nums[left]) {
                    increasingQueue.removeFirst()
                }
                left++
            }
            println("Answer: $answer diff: ${right - left}")
            answer = Math.max(answer, right - left + 1);
        }
        return answer
    }

    private fun getFirstOrElse(queue: ArrayDeque<Int>, defaultValue: Int): Int {
        return if (queue.isEmpty()) {
            defaultValue
        } else {
            queue.first()
        }
    }
}
