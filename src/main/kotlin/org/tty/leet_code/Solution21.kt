package org.tty.leet_code

class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var headNode: ListNode? = null
        var curNode: ListNode? = null

        var p1 = list1
        var p2 = list2

        fun pushNode(node: ListNode?) {
            if (headNode == null) {
                headNode = node
            } else {
                curNode!!.next = node
            }
            curNode = node
        }

        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.`val` <= p2.`val`) {
                    pushNode(p1)
                    p1 = p1.next
                } else {
                    pushNode(p2)
                    p2 = p2.next
                }
            } else if (p1 != null) {
                pushNode(p1)
                p1 = p1.next
            } else if (p2 != null) {
                pushNode(p2)
                p2 = p2.next
            }
        }
        return headNode
    }
}