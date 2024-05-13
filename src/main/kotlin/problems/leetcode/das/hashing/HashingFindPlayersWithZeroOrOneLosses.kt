package problems.leetcode.das.hashing

import problems.Problem

/**
 * You are given an integer array matches where matches[i] = [winneri, loseri]
 * indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * - answer[0] is a list of all players that have not lost any matches.
 * - answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 */
class HashingFindPlayersWithZeroOrOneLosses : Problem {
    override fun execute() {
        // Case #1
        /*
        val matches = arrayOf<IntArray>(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 6),
            intArrayOf(5, 6),
            intArrayOf(5, 7),
            intArrayOf(4, 5),
            intArrayOf(4, 8),
            intArrayOf(4, 9),
            intArrayOf(10, 4),
            intArrayOf(10, 9)
        )
        */
        // Case #2: Input: matches = [[2,3],[1,3],[5,4],[6,4]]
        val matches = arrayOf<IntArray>(
            intArrayOf(2, 3),
            intArrayOf(1, 3),
            intArrayOf(5, 4),
            intArrayOf(6, 4)
        )

        println("Matches: ${matches.contentDeepToString()}")
        println("Result: ${findWinners(matches)}")
    }

    private fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        // Players Map. For each player, you have a count for winnings and looses
        val players = mutableMapOf<Int, IntArray>()

        // Process the matches
        for (match in matches) {
            // Get the winner and update its state
            val winner = match[0]
            val winnerState = players.getOrDefault(winner, intArrayOf(0, 0))
            winnerState[0]++
            players[winner] = winnerState

            // Get the loser
            val loser = match[1]
            val loserState = players.getOrDefault(loser, intArrayOf(0, 0))
            loserState[1]++
            players[loser] = loserState
        }

        // Filter out players with only winnings
        val winners = players
            .filter { it.value[0] > 0 && it.value[1] == 0 }
            .keys
            .toList()
            .sorted()

        val oneTimeLosers = players
            .filter { it.value[1] == 1 }
            .keys
            .toList()
            .sorted()

        return listOf(winners, oneTimeLosers)
    }
}
