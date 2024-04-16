package problems.leetcode.das.arraysnstrings.prefixsum

import problems.Problem

/**
 * This is Example 2: Number of Ways to Split Array.
 *
 * Given an integer array nums, find the number of ways to split the array into two
 * parts so that the first section has a sum greater than or equal to the sum of the
 * second section. The second section should have at least one number.
 */
class Example2 : Problem {
    override fun execute() {
        val nums = intArrayOf(1, 6, 3, 2, 7, 2)
        println("Nums: ${nums.contentToString()}")
        println("Index V1: ${waysToSplitArray(nums)}")
        println("Index V2: ${waysToSplitArray2(nums)}")
    }

    private fun waysToSplitArray(nums: IntArray): Int {
        val n = nums.size

        // Build the prefix with the accumulated sums
        val prefix = LongArray(n)
        prefix[0] = nums[0].toLong()
        for (i in 1 until n) {
            prefix[i] = nums[i] + prefix[i - 1]
        }
        println("Prefix: ${prefix.contentToString()}")

        var answer = 0
        var i = 0
        while (i < n - 1) {
            val leftSection = prefix[i]
            val rightSection = prefix[n - 1] - prefix[i]
            println("-> lf: $leftSection rs: $rightSection answer: $answer")
            if (leftSection >= rightSection) {
                answer++
            }
            i++
        }

        return answer
    }

    private fun waysToSplitArray2(nums: IntArray) : Int {
        var answer = 0
        var leftSection = 0
        var total = 0

        // Calculate the TOTAL sum
        for(i in nums.indices) {
            total += nums[i]
        }

        // Calculate the arrays
        for(i in 0 until nums.size - 1 ) {
            leftSection += nums[i]
            val rightSection = total - leftSection
            if (leftSection >= rightSection) {
                answer++
            }
        }

        return answer
    }
}
