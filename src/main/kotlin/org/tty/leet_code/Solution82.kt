package org.tty.leet_code

class Solution82 {
    class Count(
        var value: Int,
        var count: Int = 1
    )

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var count: Count? = null

        val dummyNode = ListNode(0)
        dummyNode.next = head


        var prev: ListNode? = null

        var p: ListNode? = null
        var c = head

        fun checkIf() {
            if (count != null && count!!.count > 1) {
                if (prev != null) {
                    prev!!.next = c
                } else {
                    dummyNode.next = c
                }
            } else {
                prev = p
            }
        }

        while (c != null) {
            if (count == null) {
                count = Count(c.`val`)
            } else {
                if (c.`val` == count.value) {
                    count.count++
                } else {
                    checkIf()

                    count = Count(c.`val`)
                }
            }

            p = c
            c = c.next
        }

        checkIf()

        return dummyNode.next
    }
}