package problems.leetcode.das.hashing

import problems.Problem
import java.util.SortedSet

/**
 * Example 1: 49. Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 *
 * For example, given strs = ["eat","tea","tan","ate","nat","bat"],
 * return [["bat"],["nat","tan"],["ate","eat","tea"]].
 */
class MoreHashingExample1 : Problem {
    override fun execute() {

        val input = arrayOf("eat","tea","tan","ate","nat","bat")
        var output = groupByAnagram(input)
        println("Output: $output")
    }

    private fun groupByAnagram(anagrams: Array<String>) : List<List<String>> {
        val anagramMap = mutableMapOf<SortedSet<Char>, MutableList<String>>()

        anagrams.forEach { anagram ->
            val sortedAnagram = anagram.toSortedSet()
            val anagramList = anagramMap.getOrDefault(sortedAnagram, mutableListOf())
            anagramList.add(anagram)
            anagramMap[sortedAnagram] = anagramList
        }

        return anagramMap.values.toList()
    }
}
