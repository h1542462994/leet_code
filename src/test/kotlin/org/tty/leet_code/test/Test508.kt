package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution508
import org.tty.leet_code.TreeNode

class Test508 {
    @Test
    fun test508() {

        val solution = Solution508()

        val node1 = TreeNode(2)
        val node2 = TreeNode(-5)
        val node3 = TreeNode(5)
        node3.left = node1
        node3.right = node2

        val result1 = solution.findFrequentTreeSum(node3)

        println(Interact.writeIntArray(result1))
    }
}