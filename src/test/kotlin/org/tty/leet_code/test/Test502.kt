package org.tty.leet_code.test

import org.tty.leet_code.Solution502
import kotlin.test.Test

class Test502 {
    @Test
    fun test502() {
        val solution = Solution502()
        println(solution.findMaximizedCapital(2, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
    }
}