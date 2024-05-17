package problems.leetcode.das.hashing

import problems.Problem
import utils.printIntMapContents

/**
 * Example 3: 2342. Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed array nums consisting of positive integers.
 * You can choose two indices i and j, such that i != j, and the sum of
 * digits of the number nums[i] is equal to that of nums[j].
 *
 * Return the maximum value of nums[i] + nums[j] that you can obtain over
 * all possible indices i and j that satisfy the conditions.
 *
 * Return -1 if there is no pair of numbers with the same digit sum.
 */
class MoreHashingExample3 : Problem {
    override fun execute() {
        //val input = intArrayOf(18,43,36,13,7) // 54
        //val input = intArrayOf(9,2,2,5) // 4
        val input = intArrayOf(368,369,307,304,384,138,90,279,35,396,114,328,251,364,300,191,438,467,183) // 835
        //val input = intArrayOf(229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401) // 973
        //val input = intArrayOf(383,77,97,261,102,344,150,130,55,337,401,498,21,5)
        println("Input: ${input.contentToString()}")
        println("Maximum Found: ${maximumSum2(input)}")
    }

    private fun maximumSum2(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()

        // Prepare the MAP
        nums.forEachIndexed { index, i ->
            val numberAsList = i.toString().toList()
            var key = 0
            numberAsList.forEach {
                key += it.digitToInt()
            }
            val mutableList = map.getOrDefault(key, mutableListOf())
            mutableList.add(i)
            map[key] = mutableList
        }

        printIntMapContents(map)

        // Find KEY between the keys whose value is the largest
        var largestNumber = 0
        map.entries.filter {
            it.value.size >= 2
        }.forEach {
            val sortedList = it.value.sortedDescending()
            val localBest = sortedList[0] + sortedList[1]
            largestNumber = Math.max(largestNumber, localBest)
        }

        return largestNumber
    }

    private fun maximumSum(nums: IntArray): Int {
        val map = mutableMapOf<Int, MutableList<Int>>()

        // Prepare the MAP
        nums.forEachIndexed { index, i ->
            val numberAsSet = i.toString().toSortedSet()
            var key = 0
            numberAsSet.forEach {
                key += it.digitToInt()
            }
            val mutableList = map.getOrDefault(key, mutableListOf())
            mutableList.add(i)
            map[key] = mutableList
        }

        printIntMapContents(map)

        // Find KEY between the keys whose value is the largest
        var largestNumber = 0
        map.entries.filter {
            it.value.size >= 1
        }.forEach {
            largestNumber = Math.max(largestNumber, it.key)
        }
        println("Largest Key: " + largestNumber)

        // Process the values for the selected keys
        val list = map.getOrDefault(largestNumber, mutableListOf())
        return if (list.size < 2) {
            -1
        } else {
            list.sum()
        }
    }

}