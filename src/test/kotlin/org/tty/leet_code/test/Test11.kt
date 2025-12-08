package org.tty.leet_code.test

import org.tty.leet_code.Solution11
import kotlin.test.Test

class Test11 {
    @Test
    fun test11() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val solution = Solution11()

        println(solution.maxArea(height))
    }
}