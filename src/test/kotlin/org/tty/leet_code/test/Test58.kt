package org.tty.leet_code.test

import org.tty.leet_code.Solution58
import kotlin.test.Test

class Test58 {
    @Test
    fun test58() {
        val s = "   fly me   to   the moon  "
        val solution = Solution58()
        println(solution.lengthOfLastWord(s))
    }
}