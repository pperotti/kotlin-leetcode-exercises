package problems.leetcode.das.queues

import problems.Problem

/**
 * Example: 933. Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/submissions/1323403915/
 *
 * Implement the RecentCounter class. It should support ping(int t), which records a call at
 * time t, and then returns an integer representing the number of calls that have happened in
 * the range [t - 3000, t]. Calls to ping will have increasing t.
 */
class QueuesNumberOfRecentCalls : Problem {
    override fun execute() {
        val rc = RecentCounter()
        println("ping(1): ${rc.ping(1)}")
        println("ping(100): ${rc.ping(100)}")
        println("ping(3001): ${rc.ping(3001)}")
        println("ping(3002): ${rc.ping(3002)}")
    }
}

class RecentCounter() {

    val queue = ArrayDeque<Int>()

    fun ping(t: Int): Int {

        // Figure out new range
        val range : Pair<Int, Int> = t-3000 to t

        // Add element to the end of the queue
        queue.addLast(t)

        // Count how many elements are in the identified range
        var count = 0
        val size = queue.size
        var pos = size - 1
        while (pos >= 0) {
            val e = queue.elementAt(pos)
            if (e >= range.first && e <= range.second ) {
                count++
            } else {
                break;
            }
            pos--
        }

        return count
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */