package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * You are given an integer array nums consisting of n elements,
 * and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that
 * has the maximum average value and return this value.
 *
 * Any answer with a calculation error less than 10-5 will be
 * accepted.
 */
class ProblemMaximumAverageSubarray : Problem {
    override fun execute() {
        // [-1]
        // 1
        //val nums = intArrayOf(-1)
        //val k = 1

        //[6,8,6,8,0,4,1,2,9,9]
        //2
        //val nums = intArrayOf(6,8,6,8,0,4,1,2,9,9)
        //val k = 2

        //val nums = intArrayOf(0,1,1,3,3)
        //val k = 4

        //[1,12,-5,-6,50,3]
        //4
        //val nums = intArrayOf(1,12,-5,-6,50,3)
        //val k = 4

        //[4433,-7832,-5068,4009,2830,6544,-6119,-7126,-780,-4254,-8249,-9168,9492,402,5789,6808,8953,5810,-7353,7933,4766,5182,-3230,-1989,5786,6922,-4646,4415,-9906,807,-6373,3370,2604,8751,-9173,-2668,-6876,9500,3465,-1900,4134,-1758,-1453,-5201,-9825,4469,-1999,-1108,1836,3923,6796,-5252,9863,-5997,-3251,9596,-3404,-540,2826,-1737,3341,-3623,-9885,2603,-5782,8174,2710,6504,-4128]
        //59
        //expecected: 526.37288
        //val nums = intArrayOf(4433,-7832,-5068,4009,2830,6544,-6119,-7126,-780,-4254,-8249,-9168,9492,402,5789,6808,8953,5810,-7353,7933,4766,5182,-3230,-1989,5786,6922,-4646,4415,-9906,807,-6373,3370,2604,8751,-9173,-2668,-6876,9500,3465,-1900,4134,-1758,-1453,-5201,-9825,4469,-1999,-1108,1836,3923,6796,-5252,9863,-5997,-3251,9596,-3404,-540,2826,-1737,3341,-3623,-9885,2603,-5782,8174,2710,6504,-4128)
        //val k = 59

        //[8535,-7482,-9148,4029,4086,-2863,-761,-1968,-9685,-6176,-1254,2445,1039,2321,917,-2641,-8077,6421,7040,5340,4639,5261,-7277,4932,4253,-5315,1561,-5930,-6204,-3061,401,7519,-9094,7907,847,5083,6096,-9552,6772,7985,-444,-2886,6317,4966,-6980]
        //45
        //220.31111
        val nums = intArrayOf(8535,-7482,-9148,4029,4086,-2863,-761,-1968,-9685,-6176,-1254,2445,1039,2321,917,-2641,-8077,6421,7040,5340,4639,5261,-7277,4932,4253,-5315,1561,-5930,-6204,-3061,401,7519,-9094,7907,847,5083,6096,-9552,6772,7985,-444,-2886,6317,4966,-6980)
        val k = 45

        val answer = findMaxAverage(nums, k)
        println("Numbers: ${nums.contentToString()} Size: ${nums.size} K: $k")
        println("Max Avg: $answer")
    }

    private fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = 0
        var answer = Int.MIN_VALUE.toDouble() // Value that will hold the actual answer.
        val times = if (nums.size >= k) {
            nums.size - k + 1
        } else {
            nums.size
        }.toInt()

        for (iter in 0 until times) {
            var limit = left + k
            var div = k
            if (limit > nums.size) {
                limit = nums.size
                div = nums.size
            }
            var curr = 0.0
            for (actual in left until limit) {
                curr += nums[actual]
            }
            answer = Math.max(answer, curr / div)
            println("Left: $left Answer: $answer Div: $div Curr: $curr Res: ${curr / div} Times: $times")
            left++
        }
        return answer
    }
}