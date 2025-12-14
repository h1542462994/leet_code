package org.tty.leet_code.test

import org.tty.leet_code.Solution219
import kotlin.test.Test

class Test219 {
    @Test
    fun test219() {
        val solution = Solution219()
        println(solution.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    }
}