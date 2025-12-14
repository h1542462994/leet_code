package org.tty.leet_code.test

import org.tty.leet_code.Solution909
import kotlin.test.Test

class Test909 {
    @Test
    fun test909() {
        val solution = Solution909()
        val board = arrayOf(
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,35,-1,-1,13,-1),
            intArrayOf(-1,-1,-1,-1,-1,-1),
            intArrayOf(-1,15,-1,-1,-1,-1)
        )

        println(solution.snakesAndLadders(board))
    }
}