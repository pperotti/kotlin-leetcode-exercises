package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * ARRAYS & STRINGS: Squares of a Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order,
 * Return an array of the squares of each number sorted in
 * non-decreasing order.
 */
class ProblemSquaresOfSortedArray : Problem {
    override fun execute() {
        val elems: IntArray = intArrayOf(-2, -1, 3, 5, 9, 20)
        println(elems.contentToString())
        println(sortedSquares(elems).contentToString())
    }

    /*
    Constraints:
    -> 1 <= nums.length <= 104
    -> -104 <= nums[i] <= 104
    -> nums is sorted in non-decreasing order.
     */
    private fun sortedSquares(nums: IntArray): IntArray {
        // Using Math.pow only slows down the outcome
        for(i in nums.indices) {
            val elem = nums.elementAt(i)
            nums[i] = elem * elem
        }
        nums.sort()
        return nums
    }
}