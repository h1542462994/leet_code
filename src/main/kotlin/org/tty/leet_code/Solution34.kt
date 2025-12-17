package org.tty.leet_code

class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        // 两次寻找分别找到左边界和右边界
        val result = IntArray(2)
        result[0] = searchLeftBound(nums, target)
        result[1] = searchRightBound(nums, target)
        return result
    }

    fun searchLeftBound(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size
        var mid: Int

        var find = false
        while (a < b) {
            mid = (a + b) / 2
            if (target == nums[mid]) {
                find = true
                b = mid
            } else if (target < nums[mid]) {
                b = mid
            } else {
                a = mid + 1
            }
        }
        return if (find) a else -1
    }


    fun searchRightBound(nums: IntArray, target: Int): Int {
        var a = 0
        var b = nums.size
        var mid: Int

        var find = false
        while (a < b) {
            mid = (a + b) / 2
            if (target == nums[mid]) {
                find = true
                a = mid + 1
            } else if (target < nums[mid]) {
                b = mid
            } else {
                a = mid + 1
            }
        }
        return if (find) a - 1 else -1
    }
}