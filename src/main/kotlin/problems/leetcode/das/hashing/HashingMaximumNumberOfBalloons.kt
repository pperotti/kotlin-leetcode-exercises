package problems.leetcode.das.hashing

import problems.Problem
import utils.printContents

/**
 * Given a string text, you want to use the characters of text to form
 * as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum
 * number of instances that can be formed.
 */
class HashingMaximumNumberOfBalloons : Problem {
    override fun execute() {
        //val input = "nlaebolko"
        //val input = "loonbalxballpoon"
        val input = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"
        println("Input: $input")
        println("Number of Balloons: ${maxNumberOfBalloons(input)}")
    }

    private fun maxNumberOfBalloons(text: String): Int {
        val processedWord = mutableMapOf<Char, Int>()
        val balloonMap = mutableMapOf<Char, Int>()
        balloonMap['b'] = 1
        balloonMap['a'] = 1
        balloonMap['l'] = 2
        balloonMap['o'] = 2
        balloonMap['n'] = 1

        if (text.length < 7) {
            return 0
        }

        // Create the MAP for the word received as input
        text.lowercase().forEach { c ->
            processedWord[c] = processedWord.getOrDefault(c, 0) + 1
        }

        // Evaluate if 'balloon' was found
        val expectedIterations = processedWord.getOrDefault('b', 0)
        if (expectedIterations < 1) {
            return 0
        }

        // Compare the maps
        var commonMin = expectedIterations
        balloonMap.forEach { entry ->
            val value = processedWord.getOrDefault(entry.key, 0)
            val expected = value / entry.value
            commonMin = Math.min(commonMin, expected)
        }

        return commonMin
    }
}
