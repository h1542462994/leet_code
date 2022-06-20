package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.SolutionOfferSecond029
import org.tty.leet_code.createCircleLinkedListNode
import org.tty.leet_code.iterable
import kotlin.test.assertEquals

class TestOfferSecond029 {

    private fun useTestCase(expect: List<Int>, input: List<Int>, insertVal: Int) {
        val solution = SolutionOfferSecond029()
        var node = createCircleLinkedListNode(input)
        node = solution.insert(node, insertVal)
        val list = node.iterable().toList()
        println(list)
        assertEquals(expect, list)
    }

    @Test
    fun testOfferSecond029() {
        useTestCase(listOf(3, 4, 1, 2), listOf(3, 4, 1), 2)
        useTestCase(listOf(1), listOf(), 1)
        useTestCase(listOf(1, 0), listOf(1), 0)
    }
}