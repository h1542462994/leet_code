package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution871

class Test871 {
    @Test
    fun test871() {
        val solution = Solution871()

        println(solution.minRefuelStops(1, 1, arrayOf()))
        println(solution.minRefuelStops(100, 1, stations = arrayOf(intArrayOf(10, 100))))
        println(solution.minRefuelStops(100, 10, arrayOf(intArrayOf(10, 60), intArrayOf(20, 30), intArrayOf(30, 30), intArrayOf(60, 40))))
        println(solution.minRefuelStops(100, 50, arrayOf(intArrayOf(25, 25), intArrayOf(50, 50))))
    }
}