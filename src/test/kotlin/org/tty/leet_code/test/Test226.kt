package org.tty.leet_code.test

import org.tty.leet_code.Solution226
import org.tty.leet_code.preIterable
import kotlin.test.Test

class Test226 {
    @Test
    fun test226() {
        val root = Interact.createTree(listOf(4,2,7,1,3,6,9))
        val solution = Solution226()
        val result = solution.invertTree(root)
        println(result.preIterable().toList())
    }
}