package org.tty.leet_code.test

import org.tty.leet_code.Solution33
import kotlin.test.Test

class Test33 {
    @Test
    fun test33() {
        val solution = Solution33()
        println(solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        println(solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
        println(solution.search(intArrayOf(1), 0))
    }
}