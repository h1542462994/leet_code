package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution1089

class Test1089 {
    @Test
    fun test1089() {
        val solution = Solution1089()
        val inputArr1 = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)
        solution.duplicateZeros(inputArr1)
        println(Interact.writeIntArray(inputArr1))

        val inputArr2 = intArrayOf(1, 0, 2, 3, 0, 0, 4, 5)
        // 1, 0, 0, 2, 3, 0, 0, 0, 0
        solution.duplicateZeros(inputArr2)
        println(Interact.writeIntArray(inputArr2))
    }
}