package org.tty.leet_code.test

import org.tty.leet_code.Solution149
import kotlin.test.Test

class Test149 {
    @Test
    fun test149() {
        val solution = Solution149()
        println(
            solution.maxPoints(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 2),
                    intArrayOf(5, 3),
                    intArrayOf(4, 1),
                    intArrayOf(2, 3),
                    intArrayOf(1, 4)
                )
            )
        )
    }
}