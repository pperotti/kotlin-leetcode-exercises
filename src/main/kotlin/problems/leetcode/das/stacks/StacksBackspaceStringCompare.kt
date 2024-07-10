package problems.leetcode.das.stacks

import problems.Problem

/**
 * Example 3: 844. Backspace String Compare
 *
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 *
 * For example, given s = "ab#c" and t = "ad#c", return true. Because of the backspace,
 * the strings are both equal to "ac".
 */
class StacksBackspaceStringCompare : Problem {
    override fun execute() {
        //val s = "ab##c"
        //val t = "ad##c"
        val s = "a##c"
        val t = "#a#c"
        println("s=$s t=$t")
        println("Are they the same: ${backspaceCompare(s, t)}")
    }

    private fun backspaceCompare(s: String, t: String): Boolean {
        val stack = ArrayDeque<Char>()

        // Evaluate s
        s.forEach { c ->
            if (c == '#') {
                if (stack.size > 0) {
                    stack.removeLast()
                }
            } else {
                stack.addLast(c)
            }
        }
        val cleanS = stack.joinToString(separator = "")
        stack.clear()

        // Evaluate t
        t.forEach { c ->
            if (c == '#') {
                if (stack.size > 0) {
                    stack.removeLast()
                }
            } else {
                stack.addLast(c)
            }
        }
        val cleanT = stack.joinToString(separator = "")

        // Compare resulting strings
        return cleanS == cleanT
    }
}