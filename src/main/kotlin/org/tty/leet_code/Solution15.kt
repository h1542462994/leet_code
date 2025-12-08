package org.tty.leet_code

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        nums.sort()

        if (nums[0] > 0) {
            return listOf()
        }
        for (i in 0 until nums.size) {
            if (nums[i] > 0) {
                return result
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                if (sum == 0) {
                    result.add(listOf(nums[i], nums[l], nums[r]))
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--
                    }
                    l++
                    r--
                } else if (sum > 0) {
                    r--
                } else {
                    l++
                }
            }


        }

        return result
    }
}