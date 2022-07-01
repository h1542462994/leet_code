package org.tty.leet_code

import kotlin.random.Random

/**
 * 324::Wiggle Sort II
 *
 * **Solution:**
 * 1. wiggle sort, we could find follow pattern: have floor((n + 1)/2) elements is <= mid.
 * have ceil((n - 1)/2) elements is > mid.
 * 2. for all elements, we have most floor((n + 1)/2) element are equal. like [1, 1, 2], but it will not be [1, 2, 2]. it means if have floor((n + 1)/2) elements are equal, they will be the smallest value.
 * 3. from (1), we could find **floor((n + 1)/2)^th** smallest value in nums, mark it as **mid**. and part the nums by three parts, less than mid, mid, and more than mid. mark them L,M,G. so we could prove l < m < g.
 * 4. × we could generate the nums as `[l, g, l, g, ..., l, g, m]` (odd) `[l, g, l, g, ..., l, m]` (even) we could prove the array is a wiggle sorted array.
 * 5. × use **quickPartition** to parts the nums to three parts. so it will be `[l, l, l, ..., m, g, g, ..., g]`, then make the element m to last `[l, l, l, ..., g, g, g, g, ..., m]` (swap m and last)
 * 6. × swap **l** and **g** elements i <==> (mid + i) | 1 - 1
 * 7. × optimize the (5), (6) with index map.
 *
 * **Result:**
 * - error
 * - at 2022/9/28
 */
class Solution324 {
    fun swap(arr: IntArray, i: Int, j: Int) {
        val t = arr[i]
        arr[i] = arr[j]
        arr[j] = t
    }

    fun partition(arr: IntArray, first: Int, last: Int, pivot: Int): Int {
        val pivotValue = arr[pivot]
        var newPivot = first
        swap(arr, pivot, last)
        for (i in first until last) {
            if (arr[i] < pivotValue) {
                swap(arr, i, newPivot++)
            }
        }
        swap(arr, newPivot, last)
        return newPivot
    }

    fun findKthValue(arr: IntArray, k: Int): Int {
        var first = 0
        var last = arr.size - 1
        val targetIndex = k - 1

        while (first <= last) {
            val pivot = Random.nextInt(first, last + 1)
            val newPivot = partition(arr, first, last, pivot)
            if (newPivot == targetIndex) {
                return arr[targetIndex]
            } else if (newPivot > targetIndex) {
                last = newPivot - 1
            } else {
                first = newPivot + 1
            }
        }

        return arr[targetIndex]
    }

    fun wiggleSort(nums: IntArray): Unit {
        val midIndex = nums.size / 2

        findKthValue(nums, midIndex + 1)

        // swap the mid and last element, so element will be [l, l, l, g, g, [g], m]
        swap(nums, midIndex, nums.size - 1)

        for (i in 0 until midIndex) {
            if (i % 2 == 1) {
                // swap the element i (oddIndex) <==> (midIndex + i) | 1 - 1 (evenIndex) (最近的比它小的偶数)
                swap(nums, i, ((midIndex + i) or 1) - 1)
            }
        }
    }
}

class Solution324V2() {
    fun wiggleSort(nums: IntArray) {
        // sort the array
        nums.sort()
        // generate the new num with index map
        val newNums = IntArray(nums.size)
        // 4 -> 2, 5 -> 2
        val midIndex = nums.size / 2
        val rightStart = if (nums.size % 2 == 0) {
            midIndex
        } else {
            midIndex + 1
        }

        // 奇数下标和偶数下标分别放前半段和后半段。
        // 从大往小放置，这样做是为了防止测试用例中[4, 5, 5, 6]错误。 [5, 6, 4, 5]
        // rightStart = 3
        // 0, 1, 2, 3, 4 => 2, 4, 1, 3, 0
        // rightStart = 4
        // 0, 1, 2, 3, 4, 5, 6 => 3, 6, 2, 5, 1, 4, 0
        // rightStart = 2
        // 0, 1, 2, 3 => 1, 3, 0, 2
        // 0 => 0
        // 0, 1 => 0, 1
        // 0, 1, 2 => 1, 2, 0

        for (i in nums.indices) {
            if (i % 2 == 0) {
                newNums[i] = nums[rightStart - 1 - i / 2]
            } else {
                newNums[i] = nums[nums.size - 1 - i / 2]
            }
        }


        newNums.copyInto(nums)
    }
}

/**
 * use virtual intArray map, and three-depart the array.
 */
class Solution324V3() {
    var nums: Int = 0
    var midIndex = 0
    var rightStart = 0

    fun prepare(nums: Int) {
        this.nums = nums
        this.midIndex = nums / 2
        this.rightStart = if (nums % 2 == 0) {
            midIndex
        } else {
            midIndex + 1
        }
    }

    /**
     * f^-1(x) = y
     * 虚地址映射
     */
    fun mapU(i: Int): Int {
        // rightStart = 3
        // 0, 1, 2, 3, 4 => 2, 4, 1, 3, 0
        // rightStart = 4
        // 0, 1, 2, 3, 4, 5, 6 => 3, 6, 2, 5, 1, 4, 0
        // rightStart = 2
        // 0, 1, 2, 3 => 1, 3, 0, 2
        // 0 => 0
        // 0, 1 => 0, 1
        // 0, 1, 2 => 1, 2, 0
        if (nums <= 2) {
            return i
        }

        return if (i < rightStart) {
            nums - 1 - 2 * i - (if (nums % 2 == 0) 1 else 0)
        } else {
            nums - 1 - 2 * (i - rightStart) - (if (nums % 2 == 1) 1 else 0)
        }
    }

    // 使用虚地址的读
    fun read(nums: IntArray, i: Int): Int {
        return nums[mapU(i)]
    }

    // 使用虚地址的写
    fun write(nums: IntArray, i: Int, v: Int) {
        nums[mapU(i)] = v
    }

    // 使用虚地址的交换
    fun swap(nums: IntArray, i: Int, j: Int) {
        val t = read(nums, i)
        write(nums, i, read(nums, j))
        write(nums, j, t)
    }

    // 使用虚地址的partition
    fun partition(nums: IntArray, first: Int, last: Int, pivot: Int): Int {

        val pivotValue = read(nums, pivot)
        var newPivot = first
        swap(nums, pivot, last)
        for (i in first until last) {
            if (read(nums, i) < pivotValue) {
                swap(nums, i, newPivot++)
            }
        }
        swap(nums, newPivot, last)
        return newPivot
    }

    fun findKthValue(arr: IntArray, k: Int): Int {
        var first = 0
        var last = arr.size - 1
        val targetIndex = k - 1

        while (first <= last) {
            val pivot = Random.nextInt(first, last + 1)
            val newPivot = partition(arr, first, last, pivot)
            if (newPivot == targetIndex) {
                return read(arr, targetIndex)
            } else if (newPivot > targetIndex) {
                last = newPivot - 1
            } else {
                first = newPivot + 1
            }
        }

        return read(arr, targetIndex)
    }


    fun wiggleSort(nums: IntArray) {

        /**
         * 定义： F(:A) = :B
         * 假设对于泛函F，满足:A是排序的数组，:B是满足要求的数据。
         * 此时我们可以构建一个数组F^-1(:A) = :C
         * 那么就可以推出F(F^-1(:A)) = F^0(:A) = :A
         * 那么就有：若:C是以排序的数组，则:A就是满足的数据。
         *
         * 我们构建一个映射F^-1(:A) (虚数组)，对其进行排序，则排序完成之后，:A自然就是我们需要的数据。
         * 设 f(i) = j指 F内元素的对应关系。可以证明其是一个双射。
         */
        prepare(nums.size)
        val value = findKthValue(nums, midIndex + 1)
        var i = midIndex - 1
        var j = midIndex + 1
        for (t in nums.indices) {
            if (t <= i && read(nums, t) == value) {
                swap(nums, i--, t)
            }
            if (t >= j && read(nums, t) == value) {
                swap(nums, j++, t)
            }
        }

    }
}