package org.tty.leet_code.test

import org.tty.leet_code.Solution14
import kotlin.test.Test

class Test14 {
    @Test
    fun test14() {
        val strs = arrayOf("flower", "flow", "flight")
        val solution = Solution14()
        println(solution.longestCommonPrefix(strs))
    }
}