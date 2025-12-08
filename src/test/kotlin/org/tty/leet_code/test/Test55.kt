package org.tty.leet_code.test

import org.tty.leet_code.Solution55
import kotlin.test.Test

class Test55 {
    @Test
    fun test55() {
        val nums1 = intArrayOf(1, 1, 2, 2, 0, 1, 1)
        val solution55 = Solution55()
        println(solution55.canJump(nums1))

        val nums2 = intArrayOf(3, 2, 1, 0, 4)
        println(solution55.canJump(nums2))
    }
}