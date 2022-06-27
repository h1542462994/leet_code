package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution522V2

class Test522 {
    @Test
    fun test522() {
        val solution = Solution522V2()

        println(solution.findLUSlength(arrayOf("aba", "cdc", "eae")))
        println(solution.findLUSlength(arrayOf("aaa", "aaa", "aa")))
        println(solution.findLUSlength(arrayOf("aabbcc", "aabbcc", "cb")))
        println(solution.findLUSlength(arrayOf("aabbcc", "aabbcc", "c", "e", "aabbcd")))
    }
}