package problems.leetcode.das.hashing

import problems.Problem

class HashingMissingNumber : Problem {
    override fun execute() {
        //val nums = intArrayOf(1,2,3,4,5,6,8,0)
        //val nums = intArrayOf(0,1)
        val nums = intArrayOf(9,6,4,2,3,5,7,0,1)
        println("Input: ${nums.contentToString()}")
        println("Missing Number: ${missingNumber2(nums)}")
    }

    /*
     * Run Time: O(n)
     * Storage: O(n)
     */
    private fun missingNumber1(nums: IntArray): Int {
        val n = nums.size
        val missing = mutableSetOf<Int>()

        // All possible numbers are initially missing
        for (i in 0 .. n) {
            missing.add(i)
        }

        // Remove all existing numbers leaving only those actually missing
        for (i in nums.indices) {
            missing.remove(nums[i])
        }

        return missing.first()
    }

    /*
     * Run Time: O(n)
     * Storage: O(1)
     */
    private fun missingNumber2(nums: IntArray): Int {
        val n = nums.size
        var totalSum = 0

        // Sum all the items in the range
        for (i in 0 .. n) {
            totalSum += i
        }

        // Remove all the items in nums leaving the sum equals to the missing number
        for (i in nums.indices) {
            totalSum -= nums[i]
        }

        return totalSum
    }
}