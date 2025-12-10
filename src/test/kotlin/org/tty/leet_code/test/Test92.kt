package org.tty.leet_code.test

import org.tty.leet_code.Solution92
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test92 {
    @Test
    fun test92() {
        val head = Interact.createLinkedListNode(listOf(1, 2, 3, 4, 5))
        val solution = Solution92()
        val result = solution.reverseBetween(head, 1, 2)

        println(result.listIterable().toList())
    }
}