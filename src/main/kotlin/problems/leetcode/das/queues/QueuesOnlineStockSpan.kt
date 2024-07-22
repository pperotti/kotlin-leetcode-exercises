package problems.leetcode.das.queues

import problems.Problem

/**
 * ONLINE STOCK SPAN
 *
 * Design an algorithm that collects daily price quotes for some stock and
 * returns the span of that stock's price for the current day.
 *
 * The span of the stock's price in one day is the maximum number of consecutive
 * days (starting from that day and going backward) for which the stock price
 * was less than or equal to the price of that day.
 *
 * For example, if the prices of the stock in the last four days is [7,2,1,2]
 * and the price of the stock today is 2, then the span of today is 4 because
 * starting from today, the price of the stock was less than or equal 2 for 4
 * consecutive days.
 *
 * Also, if the prices of the stock in the last four days is [7,34,1,2] and
 * the price of the stock today is 8, then the span of today is 3 because
 * starting from today, the price of the stock was less than or equal 8 for 3
 * consecutive days.
 *
 * Implement the StockSpanner class:
 *
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's
 * price is price.
 */
class QueuesOnlineStockSpan : Problem {
    override fun execute() {
        val stockSpanner = StockSpanner()
        println("next(100): ${stockSpanner.next(100)}")
        println("next(80): ${stockSpanner.next(80)}")
        println("next(60): ${stockSpanner.next(60)}")
        println("next(70): ${stockSpanner.next(70)}")
        println("next(60): ${stockSpanner.next(60)}")
        println("next(75): ${stockSpanner.next(75)}")
        println("next(85): ${stockSpanner.next(85)}")
    }
}

class StockSpanner {

    private val queue = ArrayDeque<Int>()

    fun next(price: Int): Int {
        queue.addLast(price)
        // Count how many elements from the queue meets the criteria
        var count = 0
        for (i in queue.size - 1 downTo 0) {
            if (queue.elementAt(i) <= price ) {
                count++
            } else {
                break
            }
        }
        return count
    }

}