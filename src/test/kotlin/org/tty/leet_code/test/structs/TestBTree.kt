package org.tty.leet_code.test.structs

import org.tty.leet_code.structs.BTree
import kotlin.test.Test

class TestBTree {
    @Test
    fun testBTree() {
        val bTree = BTree<Int>(order = 5)
        for (i in 0 until 100) {
            bTree.insert(i)
        }

        for (i in 0 until 100) {
            bTree.remove(i)
        }

        println(bTree)
    }
}