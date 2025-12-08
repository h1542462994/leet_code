package org.tty.leet_code.test

import org.tty.leet_code.Solution289
import kotlin.test.Test

class Test289 {
    @Test
    fun test289() {
        val solution = Solution289()
        solution.gameOfLife(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)))
    }
}