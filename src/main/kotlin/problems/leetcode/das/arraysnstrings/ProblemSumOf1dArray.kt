package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * Running Sum of 1D Array
 *
 * Given an array nums. We define a running sum of an array as
 * runningSum[i] = sum(num[0] ... num[i]).
 *
 * Return the running sum of nums.
 */
class ProblemSumOf1dArray : Problem {
    override fun execute() {
        //val nums = intArrayOf(1,2,3,4)
        //val nums = intArrayOf(1,1,1,1,1)
        val nums = intArrayOf(3,1,2,10,1)
        println(sumOf1dArray(nums).contentToString())
    }

    private fun sumOf1dArray(nums: IntArray) : IntArray {
        for (i in 1 until nums.size) {
            nums[i] = nums[i] + nums[i-1]
        }
        return nums
    }
}
