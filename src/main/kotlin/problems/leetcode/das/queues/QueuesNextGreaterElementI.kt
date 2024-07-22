package problems.leetcode.das.queues

import problems.Problem

/**
 * Next Greater Element I
 *
 * The next greater element of some element x in an array is the first greater element
 * that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1
 * is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
 * and determine the next greater element of nums2[j] in nums2. If there is no next
 * greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater
 * element as described above.
 */
class QueuesNextGreaterElementI : Problem {
    override fun execute() {

        /*
        Input:
          nums1 = [4,1,2],
          nums2 = [1,3,4,2]
        Output:
          [-1,3,-1]
         */

        // Scenario 1
        //val nums1 = intArrayOf(4,1,2)
        //val nums2 = intArrayOf(1,3,4,2)

        // Scenario 2
//        val nums1 = intArrayOf(2,4)
//        val nums2 = intArrayOf(1,2,3,4)

        // Scenario 3
        val nums1 = intArrayOf(3,1,5,7,9,2,6)
        val nums2 = intArrayOf(1,2,3,5,6,7,9,11)

        println("Input - nums1: ${nums1.contentToString()} - nums2: ${nums2.contentToString()}")
        println("Output: ${nextGreaterElement(nums1, nums2).contentToString()}")
    }

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = IntArray(nums1.size)

        // For each number in num1, we have to search for the next greater
        nums1.forEachIndexed { index, value ->
            var nextNumber = -1
            // Find j where nums1[value] == nums2[j]
            val indexOfI = nums2.indexOf(value)
            println("index: $index - value: $value - indexOfI: $indexOfI name2[indexOfI]]: ${nums2[indexOfI]}")
            if (indexOfI + 1 < nums2.size) {
                var j = indexOfI + 1
                while (j < nums2.size) {
                    println("------ j: $j nums2[j]: ${nums2[j]}")
                    if (nums2[j] > nums1[index] && nums2[j] > nextNumber) {
                        nextNumber = nums2[j]
                        break
                    }
                    j++
                }
            }
            // Save the result
            answer[index] = nextNumber
        }

        return answer
    }
}