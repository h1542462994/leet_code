package org.tty.leet_code.test

import org.tty.leet_code.Solution57
import kotlin.test.Test

class Test57 {
    @Test
    fun test57() {
        val solution = Solution57()
        println(
            solution.insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)).toList()
                .map { Interact.writeIntArray(it) })

        println(
            solution.insert(arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)), intArrayOf(4, 8))
                .map { Interact.writeIntArray(it) }
        )
    }
}