package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * Given a string s, reverse the order of characters
 * in each word within a sentence while still
 * preserving whitespace and initial word order.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 */
class ProblemReverseWordsInAStringIII : Problem {
    override fun execute() {
        val expression = "Let's take LeetCode contest"
        println("Expression: $expression")
        println("Solution: ${reverseWords(expression)}")
    }

    private fun reverseWords(s: String): String {

        // Create 2 lists:
        // - 1 to hold the solution
        // - 1 to hold the word

        // Algorithm:
        // - Read char by char and add each letter to the buffer
        // - If a space is encounter, then flush the buffer

        val solution = mutableListOf<Char>()
        val buffer = mutableListOf<Char>()

        for (index in 0 until s.length) {
            val c = s.elementAt(index)
            //println("Char: $c")
            if (c == ' ') {
                flushBuffer(solution, buffer)
                solution.add(c)
            } else {
                buffer.add(c)
            }
        }
        flushBuffer(solution, buffer)

        return solution.joinToString(separator = "")
    }

    private fun flushBuffer(solution: MutableList<Char>, buffer: MutableList<Char>) {
        val bSize = buffer.count()
        for (b in bSize-1 downTo 0) {
            solution.add(buffer[b])
        }
        buffer.clear()
    }
}
