package problems.leetcode.das.hashing

import problems.Problem
import utils.readContentsFromFile
import java.io.File

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

        /*
        val input = intArrayOf(
            1,1,1,1,1,1,1,0,0,0,
            0,1,1,0,1,0,0,1,1,1,
            1,1,1,1,1,1,0,0,0,0,
            1,0,0,0,0,1,0,1,0,0,
            0,1,1,0,0,0,0,1,0,0,
            1,1,1,1,1,0,0,1,0,1,
            1,0,0,0,1,0,0,0,1,1,
            1,0,1,1,0,1,0,0,1,1,
            0,1,0,0,1,1,1,0,0,1,
            0,1,1,1,0,0,1,0,1,1) // output 94
        */


        /*
        val input = intArrayOf(
            0,1,0,1,1,1,0,0,1,1,
            0,1,1,1,1,1,1,0,1,1,
            0,1,1,0,0,0,1,0,1,0,
            0,1,0,1,1,1,1,1,1,0,
            0,0,0,1,0,0,0,1,1,1,
            0,1,0,0,1,1,1,1,1,0,
            0,1,1,1,1,0,0,1,0,1,
            1,0,0,0,0,0,0,1,0,1,
            0,1,1,0,0,1,1,0,1,1,
            1,1,0,1,1,0,0,0,1,1) // Expected 68
        */

        val input = readContentsFromFile()
        println("Input: ${input.contentToString()} Len: ${input.size}")
        println("Output: ${findMaxLength3(input)}")
    }



    fun findMaxLength3(nums: IntArray): Int {
        val count = intArrayOf(0, 0)
        var max = 0
        val left = 0
        val right = 0

        /*
        nums.forEachIndexed { index, i ->
            count[i]++
        }
        */
        for (outterIndex in 0 until nums.size) {

            println("NEW ITERATION #: $outterIndex")

        }

        println("Max Selected - c[0]=${count[0]} c[1]=${count[1]}")

        return max
    }

    fun findMaxLength2(nums: IntArray): Int {
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

        // Traverse it again
        nums.forEachIndexed { index, i ->
            count[i]--
            println("--- count[0]=${count[0]} count[1]=${count[1]}")
            if (count[0] == count[1]) {
                max = Math.max(max, count[0] * 2)
                println("Max Selected! -> $max")
            }
        }

        return max
    }
    fun findMaxLength(nums: IntArray): Int {

        val count = intArrayOf(0, 0)
        var max = 0

        for (outterIndex in 0 until nums.size) {

            println("NEW ITERATION #: $outterIndex")

            // Clean temporary data
            count[0] = 0
            count[1] = 0

            // Iterate internally
            for (innerIndex in outterIndex until nums.size) {

                val value = nums[innerIndex]
                count[value]++

                if (count[0] == count[1]) {
                    max = Math.max(max, count[0] * 2)
                    //println("Max Selected! max: $max")
                    println("---> Max - count[0]=${count[0]} count[1]=${count[1]} max: $max")
                }
            }
        }
        return max
    }
}