package org.tty.leet_code

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (k == 1) {
            return head
        }

        var newHead: ListNode? = null
        var prev: ListNode? = null
        val collector = mutableListOf<ListNode>()

        var cur = head
        while (cur != null) {
            collector.add(cur)
            cur = cur.next

            if (collector.size == k) {
                // reverse.
                if (prev != null) {
                    prev.next = collector[k - 1]
                }
                collector[0].next = cur
                for (i in 0 until k - 1) {
                    collector[i + 1].next = collector[i]
                }
                prev = collector[0]
                if (newHead == null) {
                    newHead = collector[k - 1]
                }

                collector.clear()
            }
        }

        return newHead ?: head
    }
}