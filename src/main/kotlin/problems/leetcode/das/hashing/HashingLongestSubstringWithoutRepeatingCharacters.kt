package problems.leetcode.das.hashing

import problems.Problem

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
class HashingLongestSubstringWithoutRepeatingCharacters : Problem {
    override fun execute() {
        val input = "dvdf" // output 3
        //val input = "abcabcbb" // output 3
        //val input = "bbbbb" // output 1
        //val input = "pwwkew" // output 3
        println("Input: $input")
        println("Output: ${lengthOfLongestSubstring(input)}")
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var maxFound = 0
        val uniqueChars = hashMapOf<Char, Int>()
        var currentIndex = 0

        // Iterate from the 0 until the end with the posibility o 'rewiding' when a dup is found.
        while (currentIndex < s.length) {
            // Get current char
            val c = s[currentIndex]
            if (uniqueChars.contains(c)) {
                val dupIndex = uniqueChars.getOrDefault(c, 0)
                println("Element $c duplicated at: $currentIndex. We need to move 1 index to the right and reprocess since index: $dupIndex")

                // Reset the string index to one position to the right
                currentIndex = dupIndex + 1

                // Clear Map
                uniqueChars.clear()
            } else {
                println("--> Current: $currentIndex Char: $c")
                uniqueChars[c] = currentIndex
                currentIndex++

                maxFound = Math.max(maxFound, uniqueChars.size)
            }
        }

        return maxFound
    }
}