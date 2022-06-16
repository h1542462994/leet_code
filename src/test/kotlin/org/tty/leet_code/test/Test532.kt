package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution532V2
import kotlin.test.assertEquals

class Test532 {
    @Test
    fun test532() {
        val solution532 = Solution532V2()
        assertEquals(2, solution532.findPairs(intArrayOf(3, 1, 4, 1, 5), 2))
        assertEquals(4, solution532.findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
        assertEquals(1, solution532.findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
        assertEquals(2, solution532.findPairs(intArrayOf(1, 2, 4, 4, 3, 3, 0, 9, 2, 3), 3))

    }
}

