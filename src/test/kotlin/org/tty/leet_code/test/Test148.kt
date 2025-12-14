package org.tty.leet_code.test

import org.tty.leet_code.Solution148
import org.tty.leet_code.listIterable
import kotlin.test.Test


class Test148 {
    @Test
    fun test148() {
        val solution = Solution148()
        val list = Interact.createLinkedListNode(listOf(4, 2, 1, 3))
        val result = solution.sortList(list)
        println(result.listIterable().toList())
    }
}