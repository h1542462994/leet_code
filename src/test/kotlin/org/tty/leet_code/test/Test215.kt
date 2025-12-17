package org.tty.leet_code.test

import org.tty.leet_code.Solution215
import kotlin.test.Test

class Test215 {
    @Test
    fun test215() {
        val solution = Solution215()
        println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), k = 2))
    }
}