package problems.leetcode.das.stacks

import problems.Problem

/**
 * Valid Parenthesis
 * https://leetcode.com/problems/valid-parentheses/submissions/1315732264/
 */
class StacksValidParentheses : Problem {
    override fun execute() {
        //val s = "()"
        //val s = "()[]{}"
        //val s = "(]"
        //val s = "(({()}))"
        val s = "([({()})])"
        println("Input: $s")
        println("Is Valid: ${isValid(s)}")
    }

    private fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }

        val stackQueue = ArrayDeque<Char>()
        val charTable = mutableMapOf<Char, Char>()
        charTable['('] = ')'
        charTable['{'] = '}'
        charTable['['] = ']'

        s.forEach {c ->
            if (charTable.keys.contains(c)) {
                stackQueue.addLast(c)
            } else {
                // Figure out if the current char is of the same family as the last
                val prev = stackQueue.lastOrNull()
                val expected = charTable.getOrDefault(prev, '-')
                if (c == expected) {
                    // Remove char from the stack
                    stackQueue.removeLast()
                } else {
                    return false
                }
            }
        }

        // If there are chars in the queue, we have an invalid string.
        return stackQueue.size == 0
    }
}
