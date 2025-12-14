package org.tty.leet_code

class Solution148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        var p: ListNode = head
        var q: ListNode = head

        while (q.next != null) {
            val cur = q.next!!
            if (cur.`val` >= q.`val`) {
                // 尾节点扩大
                q = cur
                continue
            }
            // 查询需要插入的节点
            var prev: ListNode? = null
            var t = p
            while (t.next != null && t != q) {
                if (t.`val` > cur.`val`) {
                    break
                }
                prev = t
                t = t.next!!
            }

            q.next = cur.next
            if (prev == null) { // 插入的是新的头节点
                cur.next = t
                p = cur
            } else {
                prev.next = cur
                cur.next = t
            }

        }
        return p
    }
}