package org.tty.leet_code.test

import org.tty.leet_code.Solution221
import kotlin.test.Test

class Test221 {
    @Test
    fun test221() {
        val solution = Solution221()

        println(solution.maximalSquare(arrayOf(
            charArrayOf('1','1','1','1','1','1','1','1'),
            charArrayOf('1','1','1','1','1','1','1','0'),
            charArrayOf('1','1','1','1','1','1','1','0'),
            charArrayOf('1','1','1','1','1','0','0','0'),
            charArrayOf('0','1','1','1','1','0','0','0')
        )))
    }
}