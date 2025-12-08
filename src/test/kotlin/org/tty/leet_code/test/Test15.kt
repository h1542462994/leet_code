package org.tty.leet_code.test

import org.tty.leet_code.Solution15
import kotlin.test.Test

class Test15 {
    @Test
    fun test15() {
//        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val solution = Solution15()
//        println(solution.threeSum(nums))

        val nums2 = intArrayOf(-100,-70,-60,110,120,130,160)
        println(solution.threeSum(nums2))
    }
}