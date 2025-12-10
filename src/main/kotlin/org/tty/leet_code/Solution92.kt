package org.tty.leet_code

class Solution92 {
    /**
     * 单趟便利的算法
     */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left >= right) {
            return head
        }

        var pre: ListNode? = null
        var cur = head

        var newHeadNode: ListNode? = head
        var a: ListNode? = null
        var b: ListNode? = null
        var index = 0
        while (pre != null || cur != null) {
            val next = cur?.next
            if (index == left - 1) {
                // 缓存前驱
                a = pre
                b = cur
            } else if (index > left - 1 && index < right) {
                // 反转
                cur!!.next = pre
            } else if (index == right) {
                // 需要注意可能会有的新head节点
                if (a == null) {
                    newHeadNode = pre
                }

                // 重新更新前驱
                a?.next = pre
                b?.next = cur

                // 无须后续迭代
                break
            }
            // 迭代
            pre = cur
            cur = next
            index++
        }
        return newHeadNode
    }
}