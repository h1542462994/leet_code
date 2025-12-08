package org.tty.leet_code.test

import org.tty.leet_code.Solution13
import kotlin.test.Test

class Test13 {
    @Test
    fun test13() {
        val str = "MCMXCIV"
        val solution = Solution13()
        println(solution.romanToInt(str))
    }
}