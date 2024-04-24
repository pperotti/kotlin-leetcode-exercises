package problems.leetcode.das.hashing

import problems.Problem

/**
 * Example 3: 1941. Check if All Characters Have Equal Number of Occurrences
 *
 * Given a string s, determine if all characters have the same frequency.
 *
 * For example, given s = "abacbc", return true. All characters appear twice.
 * Given s = "aaabb", return false. "a" appears 3 times, "b" appears 2 times.
 * 3 != 2.
 */
class CountingExample3 : Problem {
    override fun execute() {
        val s = "abababa"
        println("Input: $s")
        println("Is the input balanced? -> ${checkNumberOfOccurrences(s)}")
    }

    private fun checkNumberOfOccurrences(s: String) : Boolean {
        val counts = mutableMapOf<Char, Int>()

        // Populate the map with the number of occurrences
        s.forEach { c ->
            counts[c] = counts.getOrDefault(c, 0) + 1
        }

        // Check if the occurrence is the same for each entry in the map
        var lastFrequence = 0
        for ((k,v) in counts) {
            if (lastFrequence != 0 && v != lastFrequence) {
                return false
            }
            lastFrequence = v
        }
        return true
    }
}