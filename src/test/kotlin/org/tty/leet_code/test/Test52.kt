package org.tty.leet_code.test

import org.tty.leet_code.Solution52
import kotlin.test.Test

class Test52 {
    @Test
    fun test52() {
        val solution = Solution52()

        for (i in 1 .. 9) {
            println(solution.totalNQueens(i))
        }

    }
}