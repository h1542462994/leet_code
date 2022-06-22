package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution513

class Test513 {
    @Test
    fun test513() {
        val solution = Solution513()
        val tree1 = Interact.createTree(listOf(2, 1, 3))
        println(solution.findBottomLeftValue(tree1))

        val tree2 = Interact.createTree(listOf(1, 2, 3, 4, null, 5, 6, null, null, 7))
        println(solution.findBottomLeftValue(tree2))
    }
}