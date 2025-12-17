package org.tty.leet_code

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return 0
        } else if (nums.size == 1) {
            return if (target == nums[0]) 0 else -1
        }

        var a = 0
        var b = nums.size
        var mid: Int

        val pa = nums[a]
        val pb = nums[b - 1]

        if (target > pb && target < pa) {
            return -1
        } else if (target == pa) {
            return 0
        } else if (target == pb) {
            return nums.size - 1
        }

        while (a < b) {
            mid = (a + b) / 2
            val cur = nums[mid]
            if (target == nums[mid]) {
                return mid
            }

            if (cur > pa) {
                if (target > pa && target < cur) {
                    // search left.
                    b = mid
                } else {
                    a = mid + 1
                }
            } else { // target < pb
                if (target > cur && target < pb) {
                    // search right
                    a = mid + 1
                } else {
                    b = mid
                }
            }
        }
        return -1
    }


}