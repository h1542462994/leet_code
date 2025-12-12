package org.tty.leet_code.test

import org.tty.leet_code.Solution106
import org.tty.leet_code.flatIterable
import kotlin.test.Test

class Test106 {
    @Test
    fun test106() {
        val solution = Solution106()
        val result = solution.buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
        println(result.flatIterable().toList())
    }
}