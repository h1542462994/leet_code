package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.SolutionOfferSecond091
import kotlin.test.assertEquals

class TestOfferSecond091 {
    @Test
    fun testOfferSecond091() {
        val solution = SolutionOfferSecond091()
        val costs = arrayOf(intArrayOf(3, 5, 3), intArrayOf(6, 17, 6), intArrayOf(7, 13, 18), intArrayOf(9, 10, 18))
        assertEquals(26, solution.minCost(costs))
    }
}