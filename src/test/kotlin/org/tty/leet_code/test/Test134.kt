package org.tty.leet_code.test

import org.tty.leet_code.Solution134
import kotlin.test.Test

class Test134 {
    @Test
    fun test134() {
        val gas = intArrayOf(1, 2, 3, 4, 5)
        val cost = intArrayOf(3, 4, 5, 1, 2)

        val solution = Solution134()
        println(solution.canCompleteCircuit(gas, cost))
    }
}