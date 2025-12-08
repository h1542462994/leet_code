package org.tty.leet_code.test

import org.tty.leet_code.Solution6
import kotlin.test.Test

class Test6 {

    @Test
    fun test6() {
        val s = "PAYPALISHIRING"
        val solution = Solution6()

        println(solution.convert(s, 3))
        println(solution.convert(s, 4))
        println(solution.convert("A", 1))
    }
}