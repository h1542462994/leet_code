package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution1175

class Test1175 {
    @Test
    fun test1175() {
        val solution = Solution1175()
        for (i in 1 .. 100) {
            println(solution.numPrimeArrangements(i))
        }
    }
}