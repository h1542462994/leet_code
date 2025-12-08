package org.tty.leet_code.test

import org.tty.leet_code.Solution122
import kotlin.test.Test

class Test122 {
    @Test
    fun test122() {
        val prices = intArrayOf(7, 1, 5, 3, 6, 4)
        val solution122 = Solution122()
        println(solution122.maxProfit(prices))
    }
}