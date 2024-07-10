package problems.leetcode.das.stacks

import problems.Problem

/**
 * Example 2: 1047. Remove All Adjacent Duplicates In String
 * URL: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 *
 * You are given a string s. Continuously remove duplicates (two of the same character beside
 * each other) until you can't anymore. Return the final string after this.
 *
 * For example, given s = "abbaca", you can first remove the "bb" to get "aaca". Next, you can
 * remove the "aa" to get "ca". This is the final answer.
 */
class StacksRemoveAdjacentDuplicates : Problem {
    override fun execute() {
        //val s = "abbaca"
        val s = "azxxzy"
        println("Input: $s")
        println("After removingDuplicates: ${removeDuplicates(s)}")
    }

    private fun removeDuplicates(s: String): String {
        val stack = ArrayDeque<Char>()

        s.forEach {c ->

            // Get the last element
            val prev = stack.lastOrNull()

            // Add it to the end
            if (prev == c) {
                stack.removeLast()
            } else {
                stack.addLast(c)
            }
        }

        return stack.joinToString(separator = "")
    }
}