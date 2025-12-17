package org.tty.leet_code

import java.util.PriorityQueue

class Solution502 {
    data class Item(
        val profit: Int,
        val capital: Int
    ) : Comparable<Item> {
        override fun compareTo(other: Item): Int {
            return other.profit.compareTo(profit)
        }
    }

    fun findMaximizedCapital(k: Int, w: Int, profit: IntArray, capital: IntArray): Int {
        val items = profit.indices.map { Item(profit[it], capital[it]) }
        val itemsQueue = PriorityQueue(items)

        var count = 0 // 项目个数
        var fund = w // 当前资本

        while (count < k) {
            val topItems = mutableListOf<Item>()
            while (itemsQueue.isNotEmpty()) {
                // 取出一个元素
                val cur = itemsQueue.poll()

                if (fund < cur.capital) { // 起始资金不足
                    topItems.add(cur) // 放入到待选项
                } else { // 资金充足
                    fund += cur.profit // 盈利
                    itemsQueue.addAll(topItems) // 放回待选项
                    break
                }
            }
            // 没有后续的项目了，直接结束
            if (itemsQueue.isEmpty()) {
                break
            }

            count++
        }
        return fund
    }
}