package problems.leetcode.das.hashing

import problems.Problem

class HashingCheckifSentenceIsPangram : Problem {
    override fun execute() {
        //val sentence = "thequickbrownfoxjumpsoverthelazydog"
        val sentence = "leetcode"
        println("Sentence: $sentence")
        println("Is pangram: ${checkIfPangram(sentence)}")
    }

    private fun checkIfPangram(sentence: String): Boolean {
        var isPangram = false
        val uniqueChars = mutableSetOf<Char>()
        // Add the unique chars
        for (i in sentence.indices) {
            if (!uniqueChars.contains(sentence[i])) {
                uniqueChars.add(sentence[i])
            }
        }
        if (uniqueChars.size == 26) {
            isPangram = true
        }
        return isPangram
    }
}
