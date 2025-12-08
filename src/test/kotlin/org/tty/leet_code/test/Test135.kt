package org.tty.leet_code.test

import org.tty.leet_code.Solution134
import org.tty.leet_code.Solution135
import kotlin.test.Test

class Test135 {
    @Test
    fun test135() {
        val ratings = intArrayOf(1, 3, 2, 2, 1)
        val solution = Solution135()

        println(solution.candy(ratings))
    }
}