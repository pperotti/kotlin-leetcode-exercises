package problems.leetcode.das.queues

import problems.Problem

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * You are given an array of integers nums, there is a sliding window of size k which
 * is moving from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 */
class QueuesSlidingWindowMaximum : Problem {
    override fun execute() {
        scenario2()
    }

    private fun scenario1() {
        val nums = intArrayOf(1,3,-1,-3,5,3,6,7)
        val k = 3
        println("Input: ${nums.contentToString()}")
        println("Output: ${maxSlidingWindow(nums, k).contentToString()}")
    }

    private fun scenario2() {
        val nums = utils.readIntArrayContentsFromFile("src/main/resources/slidingwindowmaximum.txt")
        val k = 10007
        println("Input: ${nums.contentToString()}")
        //println("Output: ${maxSlidingWindow(nums, k).contentToString()}")
    }

    private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answers = IntArray(nums.size - k + 1)

        for (index in answers.indices) {
            var windowMax = nums[index]
//            (1 until k).forEach { windowIndex ->
//                windowMax = windowMax.coerceAtLeast(nums[index + windowIndex])
//            }
            answers[index] = windowMax
        }

        return answers
    }
}

/**
 * This queue keep track of the max value of the window and recalculate it while it rotates
 */
class MyQueue(val windowSize: Int) {

    val queue = ArrayDeque<Int>(initialCapacity = windowSize)
    var currentMax = 0

    fun add(value: Int) {
        if (queue.size < windowSize) {
            addAndRefresh(value)
        } else {
            // Get first in the queue
            // Check if FIRST is currentMax => recalculate
            // ELSE remove the element
            val first = queue.removeFirst()
            if (first == currentMax) {
                recalculateMax()
            } else {
                addAndRefresh(value)
            }
        }
    }

    private fun addAndRefresh(value: Int) {
        queue.add(value)
        currentMax = Math.max(currentMax, value)
    }

    private fun recalculateMax() {
        queue.iterator().forEach {
            currentMax = Math.max(currentMax, it)
        }
    }
}