package org.tty.leet_code.test

import org.tty.leet_code.Solution97
import kotlin.test.Test

class Test97 {
    @Test
    fun test97() {
        val solution = Solution97()
        println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"))
    }
}