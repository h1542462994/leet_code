package org.tty.leet_code.test

import org.tty.leet_code.Solution1
import kotlin.test.Test

class Test1 {
    @Test
    fun test1() {
        val solution1 = Solution1()
        println(Interact.writeIntArray( solution1.twoSum(intArrayOf(3, 2, 4), 6)))

    }
}