package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * Given a binary array nums and an integer k, return the maximum number
 * of consecutive 1's in the array if you can flip at most k 0's.
 */
class ProblemMaxConsecutiveOnesIII : Problem {
    override fun execute() {

        //val nums = intArrayOf(1,1,0,1,0)
        //val k = 1

        //val nums = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
        //val k = 2

        // nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        val nums = intArrayOf(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1)
        val k = 3

        val answer = longestOnes(nums, k)
        println("Numbers: ${nums.contentToString()} Size: ${nums.size} K: $k")
        println("Max: $answer")
    }

    /**
     * This solutions has RUNTIME of O(n) and SPACE: O(1). This solution is better than the
     * one below.
     */
    private fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0
        var answer = 0
        var continueEvaluation = true
        var numZeros = 0

        //for (times in 0 until nums.size ) {
        while (continueEvaluation) {
            println("--> left: $left right: $right numZeros: $numZeros")
            // Evaluate right pointer
            if (nums[right]==0) {
                numZeros++
                println("-----> It's a zero - numZeros: $numZeros")
                do {
                    if (numZeros > k) {
                        // Move Left Pointer to the right
                        println("-----> Moving left pointer to left: ${left+1}")
                        if (nums[left] == 0) {
                            numZeros--
                            println("-----> nums[$left] is 0 - numZeros is now $numZeros")
                        } else {
                            println("-----> nums[$left] is 1 - numZeros is now $numZeros")
                        }
                        left++
                    }
                } while (numZeros > k && left <= right)
                right++
            } else {
                right++
            }

            answer = Math.max(answer, right - left)

            if (right > nums.size - 1) {
                continueEvaluation = false
            }
            println("-----> best answer: $answer")
        }

        return answer
    }

    /**
     * It looks like this solution is O(n^2) in worst case scenario and O(n)
     */
    private fun longestOnes2(nums: IntArray, k: Int): Int {
        var answer = 0

        for (left in 0 until nums.size) {
            var right = left
            var numZeros = 0
            var longestWindow = 0

            //println("Starting at: $right")
            while (right < nums.size) {
                if (nums[right] == 0) {
                    if (numZeros == k) {
                        break
                    } else {
                        numZeros++
                    }
                }
                //println("--> right: $right numZeros: $numZeros")
                longestWindow++
                right++
            }

            answer = Math.max(longestWindow, answer)

            //println("--> Numbers: ${nums.contentToString()} Size: ${nums.size} K: $k")
            println("--> Loop at index: $left has the best window of size: $longestWindow numZeros=$numZeros")
        }

        return answer
    }
}
