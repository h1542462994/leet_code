package org.tty.leet_code.test

import org.tty.leet_code.Solution21
import org.tty.leet_code.listIterable
import kotlin.test.Test

class Test21 {
    @Test
    fun test21() {
        val solution = Solution21()
        val list1 = Interact.createLinkedListNode(listOf(1, 2, 4))
        val list2 = Interact.createLinkedListNode(listOf(1, 3, 4))
        println(solution.mergeTwoLists(list1, list2).listIterable().toList())
    }
}