package org.tty.leet_code.test

import org.tty.leet_code.Solution322
import kotlin.test.Test

class Test322 {
    @Test
    fun test322() {
        val solution = Solution322()
        println(solution.coinChange(intArrayOf(1, 2, 5), 100))
    }
}