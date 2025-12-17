package org.tty.leet_code

import java.util.PriorityQueue

class MedianFinder {
    // 大于或等于中位数的区域，使用小顶堆存储
    val largePart: PriorityQueue<Int> = PriorityQueue<Int>()

    // 小于或等于中位数的区域
    val smallPart: PriorityQueue<Int> = PriorityQueue<Int>(Comparator<Int> { o1, o2 -> o2.compareTo(o1) })

    fun addNum(num: Int) {
        // 插入到目标区间
        if (smallPart.isEmpty() || num <= smallPart.peek()) {
            smallPart.add(num)
        } else {
            largePart.add(num)
        }

        // 平衡大小堆，使得largePart - smallPart <= 1
        while (largePart.size - smallPart.size > 1) {
            smallPart.add(largePart.poll())
        }
        while (smallPart.size - largePart.size > 1) {
            largePart.add(smallPart.poll())
        }
    }

    fun findMedian(): Double {
        // 由于largePart的个数 >= smallPart
        return if (largePart.size > smallPart.size) {
            largePart.peek().toDouble()
        } else if (largePart.size < smallPart.size) {
            smallPart.peek().toDouble()
        } else {
            (largePart.peek() + smallPart.peek()) / 2.0
        }

    }

}