package org.tty.leet_code

class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var find = false

        val dummyNode = ListNode(0)
        dummyNode.next = head
        var prevNode: ListNode ?= null

        var p: ListNode ?= null
        var c = head
        while (c != null) {
            if (c.`val` < x) {
                if (!find) {
                    prevNode = c
                } else {
                    p?.next = c.next

                    if (prevNode == null) {
                        dummyNode.next = c
                        c.next = head
                    } else {
                        val next = prevNode.next
                        prevNode.next = c
                        c.next = next
                    }
                    prevNode = c
                }
            } else if (!find) {
                find = true
                prevNode = p
            }
            p = c
            c = c.next
        }

        return dummyNode.next
    }
}