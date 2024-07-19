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
        val nums = utils.readIntArrayContentsFromFile("src/main/resources/slidingwindowmaximum2.txt")
        val k = 3
        println("Input: ${nums.contentToString()}")
        println("Expected: [3,3,5,5,6,7]")
        println("Output: ${maxSlidingWindow(nums, k).contentToString()}")
    }

    private fun scenario2() {
        val nums = utils.readIntArrayContentsFromFile("src/main/resources/slidingwindowmaximum.txt")
        val k = 10007
        println("Input: ${nums.contentToString()}")
        println("Output: ${maxSlidingWindow(nums, k).contentToString()}")
    }

    private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val answers = IntArray(nums.size - k + 1)
        val queue = MyWindowedQueue(k)

        for (index in nums.size - 1 downTo 0) {
            queue.add(nums[index])
            if (index < answers.size) {
                answers[index] = queue.queueMax
            }
        }

        return answers
    }
}

/**
 * This queue keep track of the max value of the window and recalculate it while it rotates
 */
class MyWindowedQueue(val windowSize: Int) {

    val queue = ArrayDeque<Int>(initialCapacity = windowSize)
    var queueMax = 0

    fun size() = queue.size

    fun add(value: Int) {
        queue.addFirst(value)
        //println("---> add: $value - queue.size: ${queue.size} - windowSize: $windowSize queue: ${queue}")
        if (queue.size > windowSize) {
            queue.removeLast()
            queueMax = queue.max()
            //println("---------> queueMax: $queueMax queue: $queue")
        } else if (queue.size == windowSize) {
            queueMax = queue.max()
            //println("---------> queueMax: $queueMax")
        }
    }
}
