package problems.leetcode.das.arraysnstrings.prefixsum

/**
 * This is Example 2: Number of Ways to Split Array.
 * URL:
 *
 * Given an integer array 'numbers', find the number of ways to split the array into two
 * parts so that the first section has a sum greater than or equal to the sum of the
 * second section. The second section should have at least one number.
 */
class PrefixSumExample2 {

    fun waysToSplitArray1(numbers: IntArray): Int {
        val n = numbers.size

        // Build the prefix with the accumulated sums
        val prefix = LongArray(n)
        prefix[0] = numbers[0].toLong()
        for (i in 1 until n) {
            prefix[i] = numbers[i] + prefix[i - 1]
        }

        var answer = 0
        var i = 0
        while (i < n - 1) {
            val leftSection = prefix[i]
            val rightSection = prefix[n - 1] - prefix[i]
            if (leftSection >= rightSection) {
                answer++
            }
            i++
        }

        return answer
    }

    fun waysToSplitArray2(numbers: IntArray): Int {
        var answer = 0
        var leftSection = 0
        var total = 0

        // Calculate the TOTAL sum
        for (i in numbers.indices) {
            total += numbers[i]
        }

        // Calculate the arrays
        for (i in 0 until numbers.size - 1) {
            leftSection += numbers[i]
            val rightSection = total - leftSection
            if (leftSection >= rightSection) {
                answer++
            }
        }

        return answer
    }
}
