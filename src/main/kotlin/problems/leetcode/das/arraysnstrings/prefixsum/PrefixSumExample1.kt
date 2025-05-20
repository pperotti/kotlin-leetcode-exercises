package problems.leetcode.das.arraysnstrings.prefixsum

/**
 * This is Example1 shown in Prefix Sum lesson.
 * URL:
 *
 * Given an integer array nums, an array queries where queries[ i ] = [x, y] and
 * an integer limit, return a boolean array that represents the answer to each query.
 * A query is true if the sum of the subarray from x to y is less than limit, or
 * false otherwise.
 *
 * For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]],
 * and limit = 13, the answer is [true, false, true]. For each query, the subarray
 * sums are [12, 14, 12].
 */
class PrefixSumExample1 {

    fun answerQueries(
        numbers: IntArray,
        queries: Array<IntArray>,
        limit: Int
    ): BooleanArray {
        val size = queries.size
        val prefix = IntArray(numbers.size)

        // Build the array with all the sums
        prefix[0] = numbers[0]
        for (i in 1 until numbers.size) {
            prefix[i] = prefix[i - 1] + numbers[i]
        }

        // Evaluate
        val answer = BooleanArray(size)
        for (i in 0 until queries.size) {
            val x = queries[i][0]
            val y = queries[i][1]
            val curr = prefix[y] - prefix[x] + numbers[x]
            answer[i] = curr < limit
        }

        return answer
    }
}