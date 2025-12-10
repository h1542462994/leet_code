package org.tty.leet_code.test

import org.tty.leet_code.Solution2
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test2 {
    @Test
    fun test2() {
        val node1 = Interact.createLinkedListNode(listOf(9, 9, 9, 9, 9, 9, 9))
        val node2 = Interact.createLinkedListNode(listOf(9, 9, 9, 9))

        val solution = Solution2()
        val resultNode = solution.addTwoNumbers(node1, node2)
        println(resultNode.listIterable().toList())
    }
}