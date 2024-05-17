package problems.leetcode.das.hashing

import problems.Problem
import utils.printMapWithCharAndInts

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones
 * representing the stones you have. Each character in stones is a type of stone you have.
 *
 * You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
class HashingJewelsAndStones : Problem {
    override fun execute() {
        /*
        val jewels = "aA"
        val stones = "aAAbbbb"
        */
        val jewels = "z"
        val stones = "ZZ"

        println("Input - jewels: $jewels stones: $stones")
        println("Output: ${numJewelsInStones(jewels, stones)}")
    }

    private fun numJewelsInStones(jewels: String, stones: String): Int {
        val jewelsSet = jewels.toSet()
        val stoneMap = hashMapOf<Char, Int>()
        var jewelsAndStones = 0

        // Process stones in a map
        stones.forEach { c ->
            val count = stoneMap.getOrDefault(c, 0)
            stoneMap[c] = count + 1
        }

        printMapWithCharAndInts(stoneMap)

        // Evaluate each element in set against stones
        jewelsSet.forEach { c ->
            if (stoneMap.contains(c)) {
                jewelsAndStones += stoneMap.getOrDefault(c, 0)
            }
        }

        return jewelsAndStones
    }
}