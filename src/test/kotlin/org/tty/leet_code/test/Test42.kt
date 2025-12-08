package org.tty.leet_code.test

import org.tty.leet_code.Solution42
import kotlin.test.Test

class Test42 {
    @Test
    fun test42() {
        val height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)
        val solution = Solution42()
        println(solution.trap(height))

        val height2 = intArrayOf(4, 2, 0, 3, 2, 5)
        println(solution.trap(height2))
    }
}