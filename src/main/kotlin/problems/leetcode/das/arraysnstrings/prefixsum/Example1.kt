package problems.leetcode.das.arraysnstrings.prefixsum

import problems.Problem

/**
 * This is Example1 shown in Prefix Sum lesson.
 *
 * Given an integer array nums, an array queries where queries[i] = [x, y] and
 * an integer limit, return a boolean array that represents the answer to each query.
 * A query is true if the sum of the subarray from x to y is less than limit, or
 * false otherwise.
 *
 * For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]],
 * and limit = 13, the answer is [true, false, true]. For each query, the subarray
 * sums are [12, 14, 12].
 */
class Example1 : Problem {
    override fun execute() {
        val nums = intArrayOf(1, 6, 3, 2, 7, 2)
        val queries = arrayOf(intArrayOf(0,3), intArrayOf(2,5), intArrayOf(2,4))
        val limit = 13
        val answer = answerQueries(nums, queries, limit)
        println("Nums: ${nums.contentToString()} Limit: $limit")
        println("Queries: ${queries.contentDeepToString()}")
        println("Answer: ${answer.contentToString()}")
    }

    private fun answerQueries(nums: IntArray, queries: Array<IntArray>, limit: Int) : BooleanArray {
        val size = nums.size
        val prefix = IntArray(size)

        // Build the array with all the sums
        prefix[0] = nums[0]
        for (i in 1 until size) {
           prefix[i] = prefix[i - 1] + nums[i]
        }

        // Evaluate
        val answer = BooleanArray(size)
        for (i in queries.indices) {
           val x = queries[i][0]
           val y = queries[i][1]
           val curr = prefix[y] - prefix[x] + nums[x]
           answer[i] = curr < limit
        }

        return answer
    }
}