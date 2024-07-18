package problems.leetcode.das.queues

import problems.Problem
import java.util.Stack

/**
 * Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Given an array of integers temperatures represents the daily temperatures, return an
 * array answer such that answer[i] is the number of days you have to wait after the ith day
 * to get a warmer temperature. If there is no future day for which this is possible,
 * keep answer[i] == 0 instead.
 */
class QueuesDailyTemperatures : Problem {
    override fun execute() {
//        val temperatures = intArrayOf(73,74,75,71,69,72,76,73)
        val temperatures = intArrayOf(30,40,50,60)
//        val temperatures = intArrayOf(30,60,90)
        println("Input: ${temperatures.contentToString()}")
        println("Output: ${dailyTemperatures(temperatures).contentToString()}")
    }

    private fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answers = IntArray(temperatures.size)
        val stack = Stack<Int>()
        stack.add(0)
        for(i in 1 until temperatures.size){
            val current = temperatures[i]
            while(stack.isNotEmpty() && temperatures[stack.peek()]<current){
                val day = stack.pop()
                answers[day] =  i-day
            }
            stack.add(i)
        }
        return answers
    }


//    private fun dailyTemperatures(temperatures: IntArray): IntArray {
//        val answers = IntArray(temperatures.size)
//        temperatures.forEachIndexed { index, t ->
//            var numberOfDays = 0
//            if (index + 1 < temperatures.size) {
//                val range = index + 1 until temperatures.size
//                for (indexInRange in range) {
//                    val upcomingTemperature = temperatures.elementAt(indexInRange)
//                    if (upcomingTemperature > t) {
//                        numberOfDays = indexInRange - index
//                        break
//                    }
//                }
//            }
//            answers[index] = numberOfDays
//        }
//
//        return answers
//    }
}