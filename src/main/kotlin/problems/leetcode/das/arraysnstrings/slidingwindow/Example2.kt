package problems.leetcode.das.arraysnstrings.slidingwindow

import problems.Problem

/**
 * Example 2: You are given a binary string s (a string
 * containing only "0" and "1"). You may choose up to one "0"
 * and flip it to a "1". What is the length of the longest
 * substring achievable that contains only "1"?
 *
 * For example, given s = "1101100111", the answer is 5.
 * If you perform the flip at index 2, the string becomes
 * 1111100111.
 */
class Example2 : Problem {
    override fun execute() {
        val chain = "1101100111"
        println("Answer: ${findLength(chain)}")
    }

    private fun findLength(s: String): Int {
        var left = 0
        var curr = 0 // How many '0' we have in the string
        var ans = 0

        for (right in 0..s.length-1) {
            if (s.elementAt(right) == '0') {
                curr++
            }
            while (curr > 1) {
                if (s.elementAt(left) == '0') {
                    curr--
                }
                left++
            }
            ans = Math.max(ans, right-left+1)
        }

        return ans
    }
}