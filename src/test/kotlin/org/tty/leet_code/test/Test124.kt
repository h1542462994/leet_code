package org.tty.leet_code.test

import org.tty.leet_code.Solution124
import kotlin.test.Test

class Test124 {
    @Test
    fun test124() {
        val head = Interact.createTree(listOf(5,4,8,11,null,13,4,7,2,null,null,null,1))
        val solution = Solution124()
        println(solution.maxPathSum(head))
    }
}