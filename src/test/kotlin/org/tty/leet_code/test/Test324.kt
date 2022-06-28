package org.tty.leet_code.test

import org.junit.jupiter.api.Test
import org.tty.leet_code.Solution324V3

class Test324 {
    @Test
    fun test324() {
        val solution = Solution324V3()

        val nums = intArrayOf(1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3)
        solution.wiggleSort(nums)
        println(nums.toList())
        val nums2 = intArrayOf(1, 1, 2, 1, 2, 2, 1)
        solution.wiggleSort(nums2)
        println(nums2.toList())

//        val nums = intArrayOf(1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3)
//        solution.wiggleSort(nums)
//        val nums2 = intArrayOf(1, 1, 2, 1, 2, 2, 1)
//        solution.wiggleSort(nums2)
//        val nums3 = intArrayOf(1)
//        solution.wiggleSort(nums3)
//        println(nums.toList())
//        println(nums2.toList())
//        println(nums3.toList())
    }
}