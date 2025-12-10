package org.tty.leet_code.test

import org.tty.leet_code.Solution20
import kotlin.test.Test

class Test20 {
    @Test
    fun test20() {
        val solution = Solution20()
        println(solution.isValid("()[]{}"))
        println(solution.isValid("(]"))
        println(solution.isValid("([])"))
        println(solution.isValid("([)]"))
    }
}