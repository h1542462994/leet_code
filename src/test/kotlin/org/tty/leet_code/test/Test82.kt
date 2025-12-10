package org.tty.leet_code.test

import org.tty.leet_code.Solution82
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test82 {
    @Test
    fun test82() {
        val head = Interact.createLinkedListNode(listOf(1, 2, 2, 3, 4))
        val solution = Solution82()
        val result = solution.deleteDuplicates(head)

        println(result.listIterable().toList())
    }
}