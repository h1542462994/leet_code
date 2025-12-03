package org.tty.leet_code.test

import org.tty.leet_code.Solution274
import kotlin.test.Test

class Test274 {
    @Test
    fun test274() {
        val citations = intArrayOf(1, 3, 1)
        val solution274 = Solution274()
        println(solution274.hIndex(citations))

        println(solution274.hIndex(intArrayOf(0)))
    }
}