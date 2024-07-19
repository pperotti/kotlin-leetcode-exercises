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
        // The monotonic queue will store the indices in of the elements instead of the values
        val monotonicQueue = ArrayDeque<Int>()

        for (index in nums.indices) {
            // Remove elements that are smaller than the first one in the monotonicQueue
            while (monotonicQueue.isNotEmpty() && nums[index] > nums[monotonicQueue.last()]) {
                monotonicQueue.removeLast()
            }

            // Add element to the queue
            monotonicQueue.addLast(index)

            // queue[0] is the index of the maximum element.
            // if queue[0] + k == i, then it is outside the window
            if (monotonicQueue.first() + k == index) {
                monotonicQueue.removeFirst()
            }

            // Add the answer once window has reach size k
            if (index >= k - 1) {
                answers[index - k + 1] = nums[monotonicQueue.first()]
            }
        }

        return answers
    }
}
