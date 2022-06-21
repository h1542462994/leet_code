package org.tty.leet_code.test

import org.tty.leet_code.Solution1108
import kotlin.test.Test
import kotlin.test.assertEquals

class Test1108 {
    @Test
    fun test1108() {
        val solution = Solution1108()
        assertEquals("1[.]1[.]1[.]1", solution.defangIPaddr("1.1.1.1"))
    }
}