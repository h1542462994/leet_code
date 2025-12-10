package org.tty.leet_code

class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        var a = head
        var b = head

        while (true) {
            a = a?.next
            b = b?.next?.next

            if (a == null || b == null) {
                return false
            } else if (a == b) {
                return true
            }
        }
    }
}