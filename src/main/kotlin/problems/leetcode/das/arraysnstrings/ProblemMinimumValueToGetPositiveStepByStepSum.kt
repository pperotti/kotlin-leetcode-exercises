package problems.leetcode.das.arraysnstrings

import problems.Problem
import kotlin.random.Random

/**
 * Given an array of integers nums, you start with an initial positive
 * value startValue.
 *
 * In each interaction, you calculate the step by step sum of
 * startValue plus elements in nums (from left to right).
 *
 * Return the minimum positive value of startValue such that the
 * step by step sum is never less than 1.
 *
 * IMPORTANT! Take into account that startValue have to be
 * positive! which means that it is OK to start with the
 * minimum positive value available which is 1.
 */
class ProblemMinimumValueToGetPositiveStepByStepSum : Problem {
    override fun execute() {
        //val nums = intArrayOf(-3,2,-3,4,2)
        //val nums = intArrayOf(1,2)
        val nums = intArrayOf(1,-2,-3)
        println("Value Identified: ${minStartValue(nums)}")
    }

    private fun minStartValue(nums: IntArray): Int {
        var minStartValue = 1
        var canContinue = true
        do {
            var sum = minStartValue
            var evaluationStopped = false
            for (i in nums.indices) {
                //println("-> sums: $sum num: ${nums[i]} ")
                sum += nums[i]
                if (sum < 1) {
                    //println("----> evaluation stopped! sum: $sum i: $i")
                    evaluationStopped = true
                    break
                }
            }
            if (evaluationStopped) {
                // We need to increment minStart by 1
                minStartValue++
            } else {
                // Processing can stop now, minStartValue was identified.
                canContinue = false
            }
        } while (canContinue)

        return minStartValue
    }
}