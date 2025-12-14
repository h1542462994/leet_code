package org.tty.leet_code

import kotlin.math.abs

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val numHashes = mutableMapOf<Int, MutableList<Int>>()

        for (i in nums.indices) {
            numHashes.putIfAbsent(nums[i], mutableListOf())
            numHashes[nums[i]]!!.add(i)
        }

        for (pair in numHashes) {
            val value = pair.value
            if (value.size == 2) {
                if (abs(value[0] - value[1]) <= k) {
                    return true
                }
            } else {
                value.sort()
                for (i in 0 until value.size - 1) {
                    if (value[i + 1] - value[i] <= k) {
                        return true
                    }
                }
            }
        }
        return false
    }
}