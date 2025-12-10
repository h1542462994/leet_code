package org.tty.leet_code.test

import org.tty.leet_code.Solution61
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test61 {
    @Test
    fun test61() {
        val head = Interact.createLinkedListNode(listOf(0, 1, 2))
        val solution = Solution61()

        val result = solution.rotateRight(head, 4)
        println(result.listIterable().toList())
    }
}