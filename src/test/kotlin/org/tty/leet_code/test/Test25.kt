package org.tty.leet_code.test

import org.tty.leet_code.Solution25
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test25 {
    @Test
    fun test25() {
        val solution = Solution25()
        val result = solution.reverseKGroup(Interact.createLinkedListNode(listOf(1, 2)), 3)
        println(result.listIterable().toList())
    }
}