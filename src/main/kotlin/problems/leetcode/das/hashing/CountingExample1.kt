package problems.leetcode.das.hashing

import problems.Problem
import kotlin.math.max

/**
 * Example 1: You are given a string s and an integer k.
 * Find the length of the longest substring that contains at
 * most k distinct characters.
 *
 * For example, given s = "eceba" and k = 2, return 3.
 * The longest substring with at most 2 distinct characters is "ece".
 */
class CountingExample1 : Problem {
    override fun execute() {
        val sentence = "eceba"
        val k = 2
        println("Sentence: $sentence")
        println("Longest: ${findLongestStringWithAtMost(sentence, k)}")
    }

    private fun findLongestStringWithAtMost(sentence: String, k: Int) : String {
        val chars = mutableMapOf<Char, Int>()
        var start = 0
        var answer = Pair(0, 0)
        for(curr in sentence.indices) {
            val currChar = sentence[curr]
            if (chars.contains(currChar)) {
                chars[currChar] = chars.getOrDefault(currChar, 0) + 1
            } else {
                chars[currChar] = 1
            }

            // Evaluate how it compares to k
            if (chars.size > k) {
                // Evaluate longest information
                if (chars.size > answer.second) {
                    answer = Pair(start, chars.size)
                }
                start=curr
                chars.clear()
            }
        }

        return sentence.substring(answer.first, answer.first + answer.second)
    }

    /**
     * Find the longest string with AT MOST k chars
     *
     * For each char, we find the subsequence of unique chars
     */
    private fun findLongestStringWithAtLeastK(sentence: String, k: Int): String {
        val chars = mutableSetOf<Char>()
        val len = sentence.length
        var canContinue = true
        var start = 0
        var curr = 0
        // Info about the longest string: start, size
        var answer = Pair(0, 0)
        while (canContinue) {
            val currChar = sentence[curr]
            println("CurrChar: $currChar Chars: ${chars.joinToString()} best.start: ${answer.first} best.size: ${answer.second}")
            if (chars.contains(currChar)) {
                println("...repeated char!")
                // Move the start to the right until 'curr'
                start++

                // Make sure we keep moving forward.
                // We only remove the char only if it is ok to do it
                if (start == curr) {
                    curr++
                } else {
                    chars.remove(currChar)
                    println("...char: $currChar removed! -> chars.size: ${chars.size}")
                }
            } else {
                chars.add(currChar)
                curr++
            }

            // Update info about longest
            if (chars.size > answer.second) {
                println(".... answer updated! start: $start size: ${answer.second+1}")
                answer = Pair(start, answer.second + 1)
            }

            // Determine if we reach the end of the sentence evaluation
            if (curr > len - 1) {
                canContinue = false
            }
        }

        println("join: ${chars.joinToString()}")

        // Evaluate what to return based on k and longest information
        return if (answer.second > k) {
            sentence.substring(answer.first, answer.first + answer.second)
        } else {
            ""
        }
    }
}