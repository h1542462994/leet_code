package org.tty.leet_code.test

import org.tty.leet_code.Solution238
import kotlin.test.Test

class Test238 {
    @Test
    fun test238() {
        val nums = intArrayOf(1, 2, 3, 4)
        val solution238 = Solution238()
        println(Interact.writeIntArray(solution238.productExceptSelf(nums)))
        val nums2 = intArrayOf(-1, 1, 0, -3, 3)
        println(Interact.writeIntArray(solution238.productExceptSelf(nums2)))
    }
}