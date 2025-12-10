package org.tty.leet_code.test

import org.tty.leet_code.Solution150
import kotlin.test.Test

class Test150 {
    @Test
    fun test150() {
        val solution = Solution150()
        println(solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
    }
}