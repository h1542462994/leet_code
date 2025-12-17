package org.tty.leet_code

import java.util.*
import kotlin.math.min

class Solution373 {
    data class Item(
        var a: Int,
        var b: Int,
        var index1: Int,
        var index2: Int
    ) : Comparable<Item> {
        override fun compareTo(other: Item): Int {
            return sum.compareTo(other.sum)
        }

        fun toList(): List<Int> {
            return listOf(a, b)
        }

        val sum: Int get() = a + b
    }

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val queue = PriorityQueue<Item>()

        for (i in 0 until min(nums1.size, k)) {
            queue.add(Item(nums1[i], nums2[0], i, 0))
        }

        val resultList = mutableListOf<List<Int>>()
        var count = 0
        while (count < k && queue.isNotEmpty()) {
            val cur = queue.poll()
            resultList.add(cur.toList())

            if (cur.index2 < nums2.size - 1) {
                queue.add(Item(nums1[cur.index1], nums2[cur.index2 + 1], cur.index1, cur.index2 + 1))
            }
            count++
        }
        return resultList.toList()
    }
}