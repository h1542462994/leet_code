package org.tty.leet_code

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numCount = mutableMapOf<Int, MutableList<Int>>()

        for (i in nums.indices) {
            numCount.putIfAbsent(nums[i], mutableListOf())
            numCount[nums[i]]!!.add(i)
        }

        for (num in numCount.keys) {
            if (num * 2 == target) {
                if (numCount[num]!!.size >= 2) {
                    return numCount[num]!!.toIntArray()
                }
            } else if (numCount[target - num] != null) {
                return intArrayOf(numCount[num]!!.first(), numCount[target - num]!!.first())
            }
        }
        return intArrayOf()
    }
}