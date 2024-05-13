package problems.leetcode.das.hashing

import problems.Problem

/**
 * Given an integer array nums, return the largest integer that
 * only occurs once. If no integer occurs once, return -1.
 */
class HashingLargestUniqueNumber : Problem {
    override fun execute() {
        val nums: IntArray = intArrayOf(5,7,3,9,4,9,8,3,1)
        //val nums: IntArray = intArrayOf(9,9,8,8)
        println("Input: ${nums.contentToString()}")
        println("Output: ${largestUniqueNumber(nums)}")
    }

    private fun largestUniqueNumber(nums: IntArray): Int {
        val reps = HashMap<Int, Int>()

        // Create a hash to use to count the elements
        nums.forEachIndexed { index, i ->
            if (reps.contains(i)) {
                reps.set(i, reps.getValue(i) + 1)
            } else {
                reps.set(i, 1)
            }
        }

        // Get Array with those "unique" numbers (those with number 1)
        // Soft Array in reverse
        // Return the first element of that array or -1

        // Not very efficient solution because of the additional solution
        /*val answer = reps.filterValues { value ->
            value == 1
        }
            .keys
            .sortedDescending()
            .firstOrNull() ?: -1*/

        // More efficient solution since it only iterates within
        // reps which is a subset of nums (size: m) so that means
        // O(n) in runtime complexity and O(1) in storage.
        var answer = -1
        reps.forEach {
            if (it.value == 1) {
                answer = Math.max(answer, it.key)
            }
        }

        return answer
    }
}