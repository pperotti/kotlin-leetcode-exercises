package problems.leetcode.das.arraysnstrings

import problems.Problem

/**
 * ARRAYS & STRINGS: Reverse string
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
class ProblemReverseString : Problem {

    override fun execute() {
        // If we use ArrayList
        /*val s = ArrayList<Char>()
        s.add('h')
        s.add('e')
        s.add('l')
        s.add('l')
        s.add('o')
        println("Word: ${s}")
        println("Word: ${reverseString(s)}")*/

        // If we use CharArray
        val s : CharArray = charArrayOf('a', 'b', 'c', 'd', 'e', 'f')
        println("Word: ${s.contentToString()}")
        println("Reverse Word: ${reverseString(s).contentToString()}")
    }

    private fun reverseString(s : CharArray) : CharArray {
        if (s.isEmpty()) return s

        var temp: Char
        var left = 0
        var right = s.size - 1
        while(left < right) {
            temp = s.elementAt(right)
            s.set(right, s.elementAt(left))
            s.set(left, temp)
            left++
            right--
        }
        return s
    }

    private fun reverseString(s : ArrayList<Char>) : ArrayList<Char> {
        if (s.isEmpty()) return s

        var temp: Char
        var left = 0
        var right = s.size - 1
        while(left < right) {
            temp = s.elementAt(right)
            s.set(right, s.elementAt(left))
            s.set(left, temp)
            left++
            right--
        }
        return s
    }
}
