package org.tty.leet_code.test

import org.tty.leet_code.Solution151
import kotlin.test.Test

class Test151 {
    @Test
    fun test151() {
        val s = "  hello world  ";
        val solution = Solution151()
        println(solution.reverseWords(s))
    }
}