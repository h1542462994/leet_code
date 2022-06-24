package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution515

class Test515 {
    @Test
    fun test515() {
        val solution = Solution515()
        val input1 = Interact.createTree(listOf(1, 3, 2, 5, 3, null, 9))
        println(solution.largestValues(input1))
        val input2 = Interact.createTree(listOf(1, 2, 3))
        println(solution.largestValues(input2))
    }
}