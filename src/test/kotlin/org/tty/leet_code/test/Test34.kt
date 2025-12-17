package org.tty.leet_code.test

import org.tty.leet_code.Solution34
import kotlin.test.Test

class Test34 {
    @Test
    fun test34() {
       val solution = Solution34()
       println(Interact.writeIntArray(solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)))
    }
}