package problems.leetcode.das.queues

import problems.Problem

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 */
class QueuesMovingAverageFromDataStream : Problem {
    override fun execute() {
        val movingAverage = MovingAverage(3)
        println("next(1) -> ${movingAverage.next(1)}") // return 1.0 = 1 / 1
        println("next(10) -> ${movingAverage.next(10)}") // return 5.5 = (1 + 10) / 2
        println("next(3) -> ${movingAverage.next(3)}") // return 4.66667 = (1 + 10 + 3) / 3
        println("next(5) -> ${movingAverage.next(5)}") // return 6.0 = (10 + 3 + 5) / 3
    }
}

class MovingAverage(val size: Int) {

    var partialSum : Double = 0.0
    val queue = ArrayDeque<Int>(size)

    fun next(`val`: Int): Double {
        if (queue.size >= size) {
            // Remove the last number and add the new one
            val first = queue.removeFirst()
            partialSum -= first
        }
        // Add the number and get the average
        queue.addLast(`val`)
        partialSum += `val`
        return partialSum / queue.size
    }
}