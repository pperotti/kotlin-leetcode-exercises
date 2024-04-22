package problems.leetcode.das.arraysnstrings.twopointers

import problems.Problem

class TwoPointersKRadiusSubarrayAverages : Problem {
    override fun execute() {

        val nums = IntArray(100000)
        nums.fill(100000)
        val k = 40000

        println("Nums: ${nums.contentToString()} k: $k")
        println("Solution: ${getAverages(nums, k).contentToString()}")
    }

    fun getAverages(nums: IntArray, k: Int): IntArray {

        println("getAverages() nums: ${nums.size}")

        // Perform Validations
        if (k == 0) {
            return nums
        }

        val averages = IntArray(nums.size)
        averages.fill(-1)

        if (k > nums.size) {
            return averages
        }

        // Continue with the rest of the algorithm
        val leftLimit = k
        val windowSize = (k * 2) + 1
        val rightLimit = nums.size - k

        for (i in leftLimit until rightLimit ) {
            val start = i - k
            val end = i + k
            var avg = 0L
            for (j in start..end) {
                avg += nums[j]
            }
            val avgSum: Double = (avg / windowSize).toDouble()
            avg = Math.floor(avgSum).toLong()
            //println("i: $i start: $start end: $end avgSum: $avgSum avg: $avg")
            averages[i] = avg.toInt()
        }
        return averages
    }
}