package org.tty.leet_code

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var length = 0
        var p = head
        while (p != null && p.next != null) {
            length++
            p = p.next
        }
        if (p != null) {
            length++
        }

        // 可能空节点
        if (length <= 1) {
            return head
        }
        checkNotNull(p)

        val index = length - (k % length)
        if (index == length) {
            return head
        }

        var i = 1
        var c = head
        while (i < index) {
            i++
            c = c!!.next
        }

        val result = c!!.next
        c.next = null
        p.next = head
        return result
    }
}