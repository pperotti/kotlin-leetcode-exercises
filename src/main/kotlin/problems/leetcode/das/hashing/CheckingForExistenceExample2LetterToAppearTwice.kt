package problems.leetcode.das.hashing

import problems.Problem

class CheckingForExistenceExample2LetterToAppearTwice : Problem {
    override fun execute() {
        val s = "abcdef"
        println("The first repeated character is: ${repeatedCharacter(s)}")
    }

    fun repeatedCharacter(s: String): Char {
        // We store the letter with the last index in use. The
        // value used in the map is irrelevant.
        //val existingLetters = mutableMapOf<Char, Int>()
        val existingLetters = mutableSetOf<Char>()
        for (i in s.indices) {
            val letter = s[i]
            if (existingLetters.contains(letter)) {
                return letter
            } else {
                existingLetters.add(letter)
            }
        }
        return Char.MIN_VALUE // We return an invalid value. We may throw an exception here too.
    }
}