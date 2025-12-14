package org.tty.leet_code.test

import org.tty.leet_code.Solution105
import org.tty.leet_code.structIterable
import kotlin.test.Test

class Test105 {
    @Test
    fun test105() {
       val preorder = intArrayOf(3, 9, 20, 15, 7)
       val inorder = intArrayOf(9, 3, 15, 20, 7)
       val solution = Solution105()
       val result = solution.buildTree(preorder, inorder)
       println(result.structIterable().toList())
    }
}