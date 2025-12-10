package org.tty.leet_code

class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

        var a: ListNode ?= null
        var b = head
        for (i in 0 until n - 1) {
            b = b?.next
        }

        while (b != null && b.next != null) {
            a = if (a == null) {
                head
            } else {
                a.next
            }
            b = b.next
        }

        var newHeadNode = head

        if (a == null) { // remove head node.
            newHeadNode = head?.next
        } else {
            a.next = a.next?.next
        }

        return newHeadNode
    }
}