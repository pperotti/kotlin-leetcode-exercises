package problems.leetcode.das.hashing

import problems.Problem
import utils.printMapWithCharAndInts

/**
 * Given two strings ransomNote and magazine, return true if ransomNote
 * can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
class HashingRansomNote : Problem {
    override fun execute() {

        //val ransomNote = "aa"
        //val magazine = "aba"

        val ransomNote = "bcb"
        val magazine = "cjjajdfaaeegig"

        println("Ransom Note: $ransomNote")
        println("Magazine: $magazine")
        println("Output: ${canConstruct(ransomNote, magazine)}")
    }

    private fun canConstruct(ransomNote: String, magazine: String): Boolean {

        val ransomMap = hashMapOf<Char, Int>()
        val magazineMap = hashMapOf<Char, Int>()

        // Build map of available ransomNote
        ransomNote.forEach { c ->
            val count = ransomMap.getOrDefault(c, 0)
            ransomMap[c] = count + 1
        }

        printMapWithCharAndInts(ransomMap)

        // Build map of available letters in magazine
        magazine.forEach { c ->
            val count = magazineMap.getOrDefault(c, 0)
            magazineMap[c] = count + 1
        }

        // Investigate if every element in ransomMap have enough resources in magazineMap
        var availableInMagazine = false
        for (entry in ransomMap) {
            val countInMagazine = magazineMap.getOrDefault(entry.key, 0)
            println("Letter: ${entry.key} Count: ${entry.value} CountInMagazine: $countInMagazine")
            if (entry.value <= countInMagazine) {
                availableInMagazine = true
            } else {
                availableInMagazine = false
                break
            }
        }
        return availableInMagazine
    }
}