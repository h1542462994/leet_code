package org.tty.leet_code.test

import org.tty.leet_code.Solution79
import kotlin.test.Test

class Test79 {
    @Test
    fun test79() {
        val solution = Solution79()
        val board = arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
        )
        println(solution.exist(board, "ABCCED"))
    }
}