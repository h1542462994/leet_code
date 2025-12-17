package org.tty.leet_code.test

import org.tty.leet_code.Solution153
import kotlin.test.Test

class Test153 {
    @Test
    fun test153() {
        val solution = Solution153()

        println(solution.findMin(intArrayOf(4, 5, 1, 2)))
        println(solution.findMin(intArrayOf(11, 13, 15, 17)))

    }
}