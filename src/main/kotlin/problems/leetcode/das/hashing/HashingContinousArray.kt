package problems.leetcode.das.hashing

import problems.Problem
import utils.readContentsFromFile
import java.io.File
import java.util.Arrays
import kotlin.math.max

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
        val input = intArrayOf(0,1,1,0,1,1,1,0) // output 4

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

        //val input = readContentsFromFile()
        println("Input: ${input.contentToString()} Len: ${input.size}")
        println("Output: ${findMaxLength3(input)}")
    }

    /**
     * This solution does not use hashing as it should but a count variable. The key thing
     * is to understand how count works. When count repeats while traversing the nums array
     * it means, you hit a point where 1 and 0 are balanced.
     *
     * https://leetcode.com/problems/contiguous-array/editorial/
     */
    fun findMaxLength3(nums: IntArray): Int {
        val arr = IntArray((2 * nums.size) + 1)
        Arrays.fill(arr, -2)
        arr[nums.size] = -1
        var maxLen = 0
        var count = 0

        println("Array: ${arr.contentToString()}")

        for (i in 0 until nums.size) {
            count = count + if (nums[i] == 0) -1 else 1
            println("i: $i count: $count arr[${count + nums.size}]: ${arr[count + nums.size]} (i - arr[count + nums.size]): ${i - arr[count + nums.size]}")
            if (arr[count + nums.size] >= -1 ) {
                maxLen = Math.max(maxLen, i - arr[count + nums.size])
            } else {
                arr[count + nums.size] = i
            }
            println("---> Arr: ${arr.contentToString()} maxlen: ${maxLen}")
        }

        return maxLen
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