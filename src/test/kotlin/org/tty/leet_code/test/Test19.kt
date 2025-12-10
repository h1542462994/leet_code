package org.tty.leet_code.test

import org.tty.leet_code.Solution19
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test19 {
    @Test
    fun test19() {
        val head = Interact.createLinkedListNode(listOf(1, 2, 3, 4, 5))
        val solution = Solution19()
        val result = solution.removeNthFromEnd(head, 5)

        println(result.listIterable().toList())
    }
}