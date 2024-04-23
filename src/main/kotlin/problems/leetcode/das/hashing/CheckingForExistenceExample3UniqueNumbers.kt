package problems.leetcode.das.hashing

import problems.Problem

class CheckingForExistenceExample3UniqueNumbers : Problem {
    override fun execute() {
        val nums = intArrayOf(1, 3, 4, 5, 6, 7)
        println("Entry: ${nums.contentToString()}")
        println("Solution1: ${findNumbers1(nums)}")
        println("Solution2: ${findNumbers2(nums)}")
    }

    private fun findNumbers1(nums: IntArray): List<Int> {
        val uniqueNumbers = mutableListOf<Int>()
        for (num in nums) {
            if (nums.contains(num + 1) && nums.contains(num - 1)) {
                uniqueNumbers.add(num)
            }
        }
        return uniqueNumbers
    }

    private fun findNumbers2(nums: IntArray): List<Int> {
        val uniqueNumbers = mutableListOf<Int>()
        val numberSet = mutableSetOf<Int>()
        for (num in nums) {
            numberSet.add(num)
        }
        for (num in numberSet) {
            if (numberSet.contains(num + 1) && numberSet.contains(num - 1)) {
                uniqueNumbers.add(num)
            }
        }
        return uniqueNumbers
    }
}
