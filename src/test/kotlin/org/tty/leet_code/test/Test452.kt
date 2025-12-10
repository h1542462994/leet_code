package org.tty.leet_code.test

import org.tty.leet_code.Solution452
import kotlin.test.Test

class Test452 {
    @Test
    fun test452() {
        val solution = Solution452()
        println(solution.findMinArrowShots(
            arrayOf(
                intArrayOf(9, 12),
                intArrayOf(1, 10),
                intArrayOf(4, 11),
                intArrayOf(8, 12),
                intArrayOf(3, 9),
                intArrayOf(6, 9),
                intArrayOf(6, 7)
            )
        ))
        println(solution.findMinArrowShots(
            arrayOf(
                intArrayOf(-2147483646,-2147483645),
                intArrayOf(2147483646,2147483647)
            )
        ))
    }
}