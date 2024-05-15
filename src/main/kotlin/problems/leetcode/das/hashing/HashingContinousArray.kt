package problems.leetcode.das.hashing

import problems.Problem

/**
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 */
class HashingContinousArray : Problem {
    override fun execute() {
        //val input = intArrayOf(0,1) // output 2
        //val input = intArrayOf(0,1,0) // output 2
        //val input = intArrayOf(0, 0, 1, 1, 0) // output 4
        //val input = intArrayOf(0, 1, 0, 1) // output 4
        //val input = intArrayOf(0,0,1,0,0,0,1,1) // output 6
        //val input = intArrayOf(0,1,1,0,1,1,1,0) // output 4
        val input = intArrayOf(1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1) // output 94
        println("Input: ${input.contentToString()} Len: ${input.size}")
        println("Output: ${findMaxLength(input)}")
    }

    fun findMaxLength(nums: IntArray): Int {
        val count = intArrayOf(0, 0)
        var max = 0

        // Iterate over each element
        nums.forEachIndexed { index, i ->
            count[i]++
            println("count[0]=${count[0]} count[1]=${count[1]}")
            if (count[0] == count[1]) {
                println("Max Selected!")
                max = Math.max(max, count[0] * 2)
            }
        }

        if (max == 0) { // Traverse it again
            nums.forEachIndexed { index, i ->
                count[i]--
                println("count[0]=${count[0]} count[1]=${count[1]}")
                if (count[0] == count[1]) {
                    max = Math.max(max, count[0] * 2)
                    println("Max Selected! -> $max")
                }
            }
        }

        return max
    }

}