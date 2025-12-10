package org.tty.leet_code.test

import org.tty.leet_code.Solution86
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test86 {
    @Test
    fun test86() {
        val head = Interact.createLinkedListNode(listOf(2, 1))
        val solution = Solution86()

        val result = solution.partition(head, 2)
        println(result.listIterable().toList())
    }
}