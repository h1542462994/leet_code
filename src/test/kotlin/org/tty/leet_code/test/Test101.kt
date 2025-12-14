package org.tty.leet_code.test

import org.tty.leet_code.Solution101
import kotlin.test.Test

class Test101 {
    @Test
    fun test101() {
        val root = Interact.createTree(listOf(1, 2, 2, 3, 4, 4, 3))
        val solution = Solution101()
        println(solution.isSymmetric(root))
        val root2 = Interact.createTree(listOf(1, 2, 2, null, 3, null, 3))
        println(solution.isSymmetric(root2))
    }
}