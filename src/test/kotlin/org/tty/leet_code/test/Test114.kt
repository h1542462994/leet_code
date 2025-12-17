package org.tty.leet_code.test

import org.tty.leet_code.Solution114
import org.tty.leet_code.structIterable
import kotlin.test.Test

class Test114 {

    @Test
    fun test114() {
        val node = Interact.createTree(listOf(1, null, 2, 3))
        val solution = Solution114()
        solution.flatten(node)

        println(node.structIterable().toList())
    }
}