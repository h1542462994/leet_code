package org.tty.leet_code.test

import org.tty.leet_code.Solution100
import kotlin.test.Test

class Test100 {
    @Test
    fun test100() {
        val p = Interact.createTree(listOf(2, 2, 2, null, 2, null, null, 2))
        val q = Interact.createTree(listOf(2, 2, 2, 2, null, 2, null))

        val solution = Solution100()
        println(solution.isSameTree(p, q))
    }
}