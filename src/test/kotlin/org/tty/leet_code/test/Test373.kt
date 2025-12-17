package org.tty.leet_code.test

import org.tty.leet_code.Solution373
import kotlin.test.Test

class Test373 {
    @Test
    fun test373() {
        val solution = Solution373()
        println(solution.kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), k = 9))
    }
}