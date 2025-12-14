package org.tty.leet_code.test

import org.tty.leet_code.Solution22
import kotlin.test.Test

class Test22 {
    @Test
    fun test22() {
        val solution = Solution22()
        println(solution.generateParenthesis(3))

        for (i in 1 .. 8) {
            println(solution.generateParenthesis(i))
        }
    }
}