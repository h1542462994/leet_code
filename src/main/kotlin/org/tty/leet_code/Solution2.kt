package org.tty.leet_code

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2

        var overflow = 0 // 溢出的位
        var headNode: ListNode ?= null
        var curNode: ListNode ?= null
        while (p1 != null || p2 != null) { // 仍然需要处理的
            var current = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + overflow
            if (current >= 10) {
                overflow = 1
                current -= 10
            } else {
                overflow = 0
            }

            val temp = ListNode(current)
            if (curNode == null) {
                headNode = temp
            } else {
                curNode.next = temp
            }
            curNode = temp
            p1 = p1?.next
            p2 = p2?.next
        }

        if (overflow > 0) {
            val temp = ListNode(overflow)
            if (curNode == null) {
                headNode = temp
            } else {
                curNode.next = temp
            }
        }

        return headNode
    }
}