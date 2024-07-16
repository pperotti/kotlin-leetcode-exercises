package problems.leetcode.das.stacks

import problems.Problem

/**
 * Given a string s of lower and upper case English letters.
 *
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and
 * remove them. You can keep doing this until the string becomes good.
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the
 * given constraints.
 *
 * Notice that an empty string is also good.
 *
 * Example 1:
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 */
class StacksMakeStringsGreatAgain : Problem {
    override fun execute() {
//        val s = "leEeetcode"
//        val s = "abBAcC"
        val s = "s"
        println("Input: $s")
        println("Output: ${makeStringGood(s)}")
    }

    private fun makeStringGood(s: String): String {
        val stack = ArrayDeque<Char>()
        s.forEach { c ->
            if (stack.size > 0) { // Make sure
               val last = stack.last()
               val areTheSameCharacter = c.lowercaseChar() == last.lowercaseChar()
               if (areTheSameCharacter && (c.isLowerCase() && last.isUpperCase() || c.isUpperCase() && last.isLowerCase())) {
                   stack.removeLastOrNull()
               } else {
                   stack.addLast(c)
               }
            } else {
                stack.addLast(c)
            }
        }

        return stack.joinToString(separator="")
    }
}